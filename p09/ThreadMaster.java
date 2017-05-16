package p09;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

public class ThreadMaster {

    private static int poolSize = 3;  // Limit by cores
    private static ArrayList<String> fileList = new ArrayList<>();

    public static void main(String Args[]){

        File directory = new File("");

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
        FileHandler[] pool = new FileHandler[poolSize];
        for(int threadCount = 0;threadCount<poolSize;threadCount++){

            // TODO: Remove debugger
            System.out.println("Working on thread: "+fileList.get(threadCount));

            // Create thread
            pool[threadCount] = new FileHandler(fileList.get(threadCount));
        }
    }
}
