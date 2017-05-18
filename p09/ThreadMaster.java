package p09;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMaster {

    private static DocumentStatistics dcs = new DocumentStatistics();
    private static WordSearch ws = new WordSearch();
    private static BTree bt = new BTree();

    private static int poolSize = 2;  // Limit by cores
    private static ArrayList<String> fileList = new ArrayList<>();
    private static ExecutorService executorService;

    /**
     * Main method to start the parser
     * @param Args
     */
    public static void main(String Args[]){

        // DEBUG
        long startTime = System.currentTimeMillis();

        // DEBUG -> readFiles
        if(Args[0]!=null) {
            readFiles(Args[0]);

            System.out.println("Files parsed...");
        } else {
            System.out.println("No directory omitted");
        }

        // DEBUG -> searchWord
        if(Args[1]!=null){
            searchWord(Args[1]);
        } else {
            System.out.println("No search word given");
        }


        // DEBUG -> createWordRanking
        createWordRanking();

        System.out.println("Word ranking created...");

        // DEBUG -> getTopWords
        if(Args[2]!=null){

            System.out.println("Top "+Args[2]+" are:");

            getTopWords(Integer.parseInt(Args[2]));
        } else {
            System.out.println("No top N specified, using default (10)");
        }

        System.out.println("Total words: "+dcs.getWordcount());
        System.out.println("Total unique words: "+dcs.getDifferentWordcount());
        System.out.println("Total documents: "+dcs.getDocumentCounter());
        System.out.println("Total document size: "+dcs.getDocumentSize());
        System.out.println("Average characters per document: "+dcs.getAverageDocumentCharacters());

        // DEBUG
        long stopTime = System.currentTimeMillis();
        System.out.println("Job FINALLY done in "+(stopTime-startTime)/1000+"sec");
    }

    /**
     * Read all files from given directory
     * @param userPath the directory to use for file indexing
     */
    public static void readFiles(String userPath){
        try{
            // Create fileList
            getFilesFromDirectory(new File(userPath));

            if(verifyFileList()){
                createThreads();
            }

            executorService.shutdown();
            while(!executorService.isTerminated()){
                // wait for threads to finish
            }
        } catch (NullPointerException e){
            System.out.println("Unable to read directory!");
        }

    }

    /**
     * Prints a list of all documents containing a specific word
     * @param userSearch word in question
     */
    public static void searchWord(String userSearch){

        if(userSearch!=null && ws.searchWord(userSearch) != null){

            System.out.println("Word "+userSearch+" found in ");

            for(String document : ws.searchWord(userSearch)){
                System.out.println(document);
            }

        } else {
            System.out.println("Word not found in documents");
        }
    }

    /**
     * Fills BTree with words from dcs
     */
    public static void createWordRanking(){

        for(Map.Entry<String,Integer> wordset : dcs.getWordRanking().entrySet()){
            bt.addNode(wordset.getValue(),wordset.getKey());
        }
    }

    /**
     * Prints top n words from documents
     * @param limit set a upper limit (Top10 = 10)
     */
    public static void getTopWords(int limit){
        bt.getDescendingElements(limit);
    }

    /**
     * Read all files recursive and write path in ArrayList
     * @param directory target folder to search for files
     */
    private static void getFilesFromDirectory(File directory){
        try{
            for(File element : directory.listFiles()){

                // Recursive call to subfolders
                if(element.isDirectory()){
                    getFilesFromDirectory(element);
                } else {
                    // Write path to file in arraylist
                    fileList.add(element.toString());

                    // Increase documentCounter
                    dcs.setDocumentCounter();

                    // Increase total file size
                    dcs.setDocumentSize(element.length());
                }
            }
        } catch (NullPointerException e){
            System.out.println("Could not read file from directory! NPE");
            e.printStackTrace();
        }
    }

    /**
     * Verify that at least one file is present
     * @return boolean true if there is at least one file
     */
    private static boolean verifyFileList(){
        // Check fileList length
        if(fileList.size()==0){
            System.out.println("Directory is empty");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Create a thread pool (poolSize will be overwritten if fewer files are
     * present than threads)
     *
     * Queues all documents and starts executing parser threads
     */
    private static void createThreads(){
        // Reduce the amount of threads if less files available than possible threads
        if(fileList.size()<poolSize){
            System.out.println("Reduced pool size");
            poolSize = fileList.size();
        }

        // Create threadpool
        executorService = Executors.newFixedThreadPool(poolSize);

        // Queue tasks
        for(String path : fileList){
            executorService.submit(new FileHandler(path,dcs,ws));
        }
    }
}
