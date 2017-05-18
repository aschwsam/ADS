package p09;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Read file from filesystem
 */
public class FileHandler implements Runnable{

    private String pathToFile;
    private DocumentStatistics dcs;
    private WordSearch ws;
    private int totalCharacters = 0;

    public FileHandler(String pathToFile,DocumentStatistics dcs, WordSearch ws){
        this.pathToFile = pathToFile;
        this.dcs = dcs;
        this.ws = ws;
    }

    /**
     * Read the file from disk
     */
    @Override
    public void run(){

        // DEBUG
        //long startTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+" started.");

        int wordcount = 0;
        String word = null;
        HashSet<String> localUniqueWords = new HashSet<>();
        HashMap<String,Integer> wordEncounter = new HashMap<>();

        try{
            // Stream File -> Buffer -> Scanner to grab words (delimiter default = *space*)
            Scanner scanner = new Scanner (new BufferedInputStream(new FileInputStream(pathToFile)), "UTF-8");

            // Loop through words of file
            while(scanner.hasNext()){

                word = removeSpecialChar(scanner.next());

                if(word.length()>0){

                    wordcount++;

                    // TODO: Disable this if character count is with special chars
                    totalCharacters+=word.length();

                    if(wordEncounter.containsKey(word)){
                        // Increase word encounter by one
                        wordEncounter.put(word,wordEncounter.get(word)+1);
                    } else {
                        // Add to the index
                        wordEncounter.put(word,1);

                        // Try to add word to unique wordlist
                        if(!localUniqueWords.contains(word)){

                            // Send new word to "global" set
                            dcs.setUniqueWord(word);

                            // Update local set
                            localUniqueWords.add(word);
                        }
                    }

                    // DEBUG
                    //System.out.println(word+" => "+word.length());
                }
            }

            // Send wordcount to dcs
            dcs.setWordcount(wordcount);

            // Send word encounter to dcs
            dcs.setWordRanking(wordEncounter);

            // Send document characters to dcs
            dcs.setDocumentCharacters(totalCharacters);

            // Send words to ws
            ws.addWordInDocument(wordEncounter, pathToFile);

            // DEBUG
            //long stopTime = System.currentTimeMillis();
            //System.out.println("Job done in "+(stopTime-startTime));

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Removes any non word characters from string
     * @param input
     * @return
     */
    private String removeSpecialChar(String input){

        // TODO: Enable this if character count is with special chars
        //totalCharacters+=input.length();

        return input.replaceAll("[^\\p{L}\\p{Nd}]+", "");
    }
}
