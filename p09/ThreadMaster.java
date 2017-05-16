package p09;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMaster {

    private static DocumentStatistics dcs = new DocumentStatistics();
    private static WordSearch ws = new WordSearch();

    private static int poolSize = 4;  // Limit by cores
    private static ArrayList<String> fileList = new ArrayList<>();
    private static ExecutorService executorService;

    /**
     * Main method to start the parser
     * @param Args
     */
    public static void main(String Args[]){

        // DEBUG
        long startTime = System.currentTimeMillis();

        if(Args[0]!=null){
            try{
                // Create fileList
                getFilesFromDirectory(new File(Args[0]));

                if(verifyFileList()){
                    createThreads();
                }

                executorService.shutdown();
                while(!executorService.isTerminated()){
                    // wait for threads to finish
                }

                // DEBUG
                //System.out.println("We're done...");

                long stopTime = System.currentTimeMillis();
                System.out.println("Job FINALLY done in "+(stopTime-startTime));

                if(ws.searchWord("Hello") != null){
                    for(String asd : ws.searchWord("Hello")){
                        System.out.println(asd);
                    }
                }

            } catch (NullPointerException e){
                System.out.println("Unable to read directory!");
            }
        } else {
            System.out.println("No directory omitted");
        }
    }

    /**
     * Read all files recursive and write path in ArrayList
     * @param directory
     */
    private static void getFilesFromDirectory(File directory){
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
    }

    /**
     * Verify that at least one file is present
     * @return
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
