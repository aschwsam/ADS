package p09;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMaster {

    private static DocumentStatistics dcs = new DocumentStatistics();

    private static int poolSize = 4;  // Limit by cores
    private static ArrayList<String> fileList = new ArrayList<>();
    private static FileHandler[] pool = new FileHandler[poolSize];
    private static ExecutorService executorService;

    public static void main(String Args[]){

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

                System.out.println("We're done...");
                System.out.println(dcs.getWordcount());

                long stopTime = System.currentTimeMillis();
                System.out.println("Job FINALLY done in "+(stopTime-startTime));

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

    private static boolean verifyFileList(){
        // Check fileList length
        if(fileList.size()==0){
            System.out.println("Directory is empty");
            return false;
        } else {
            return true;
        }
    }

    private static void createThreads(){
        // Reduce the amount of threads if less files available than possible threads
        if(fileList.size()<poolSize){
            System.out.println("Reduce pool size");
            poolSize = fileList.size();
        }

        // Create threadpool
        executorService = Executors.newFixedThreadPool(poolSize);

        // Queue tasks
        for(String path : fileList){
            executorService.submit(new FileHandler(path,dcs));
        }
    }
}
