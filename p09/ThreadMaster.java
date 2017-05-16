package p09;

import java.io.File;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class ThreadMaster {

    private static DocumentStatistics dcs = new DocumentStatistics();

    private static int poolSize = 5;  // Limit by cores
    private static ArrayList<String> fileList = new ArrayList<>();
    private static FileHandler[] pool = new FileHandler[poolSize];

    public static void main(String Args[]){

        if(Args[0]!=null){
            try{
                // Create fileList
                getFilesFromDirectory(new File(Args[0]));

                if(verifyFileList()){
                    createThreads();
                }

                if(fileList.size()>0){
                    for(int index = poolSize;index<fileList.size();index++){

                        // Files in queue
                        System.out.println(fileList.get(index));
                    }
                } else {
                    System.out.println("All files in use");
                }

                // Run threads
                System.out.println("Running threads");
                pool[0].start();
                pool[1].start();
                pool[2].start();
                pool[3].start();
                pool[4].start();

                // TODO: remove debug
                try{
                    sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println(dcs.getWordcount());

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
        // Reduce the amount of threads if less files available than cores
        // --> No need to spawn idle threads
        if(fileList.size()<poolSize){
            System.out.println("Reduce pool size");
            poolSize = fileList.size();
        }

        // Fill threadpool
        for(int threadCount = 0;threadCount<poolSize;threadCount++){

            // TODO: Remove debugger
            System.out.println("Creating thread for: "+fileList.get(threadCount));

            // Create thread and store in array
            pool[threadCount] = new FileHandler(fileList.get(threadCount),dcs);
        }
    }
}
