package p09;

import sun.net.www.content.text.Generic;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Read file from filesystem
 */
public class FileHandler extends Thread{

    private String pathToFile;
    private DocumentStatistics dcs;

    public FileHandler(String pathToFile,DocumentStatistics dcs){
        super();
        this.pathToFile = pathToFile;
        this.dcs = dcs;
    }

    /**
     * Read the file from disk
     */
    public void run(){

        int wordcount = 0;
        String word = null;
        ConcurrentHashMap<String,String> uniqueWords = dcs.getUniqueWords();
        HashMap<String,Integer> wordEncounter = new HashMap<>();

        try{
            // Stream File -> Buffer -> Scanner to grab words (delimiter default = *space*)
            Scanner scanner = new Scanner (new BufferedInputStream(new FileInputStream(pathToFile)), "UTF-8");

            // Loop through words of file
            while(scanner.hasNext()){

                word = scanner.next();
                wordcount++;
                if(wordEncounter.containsKey(word)){
                    // Increase word encounter by one
                    wordEncounter.put(word,wordEncounter.get(word)+1);
                } else {
                    // Add to the index
                    wordEncounter.put(word,1);

                    // Try to add word to unique wordlist
                    uniqueWords.put(word,"");
                }

                // TODO: Remove debugger
                //System.out.println(removeSpecialChar(scanner.next()));
            }

            // Send wordcount to dcs
            dcs.setWordcount(wordcount);

            // Send different words to dcs
            dcs.setDifferentWordcount(uniqueWords);

            // Send word encounter to dcs
            dcs.setWordRanking(wordEncounter);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private String removeSpecialChar(String input){
        return input.replaceAll("[^\\p{L}\\p{Nd}]+", "");
    }
}
