package p09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/**
 * This class holds global statistics about the input files
 */
public class DocumentStatistics {

    private long documentSize = 0;
    private int documentCounter = 0;
    private int documentCharactersTotal = 0;
    private int totalWords = 0;
    private int totalUniqueWords = 0;
    private HashSet<String> uniqueWords = new HashSet<>();
    private HashMap<String,Integer> wordRanking = new HashMap<>();

    public DocumentStatistics(){

    }

    public synchronized void setWordcount(int wordcount){
        totalWords+=wordcount;
    }

    public synchronized void setUniqueWord(String inputdata){
        if(!uniqueWords.contains(inputdata)){

            // TODO: Remove debug
            //System.out.println(inputdata);

            setTotalUniqueWords();
            uniqueWords.add(inputdata);
        }
    }

    public synchronized void setWordRanking(HashMap<String,Integer> inputdata){

        for(Map.Entry<String,Integer> entry : inputdata.entrySet()){

            String remote_word = entry.getKey();
            Integer remote_timesFound = entry.getValue();

            // Compare local Map with "remote"
            if(wordRanking.containsKey(remote_word)){

                // Retrieve values from wordRanking and increase counter
                wordRanking.put(remote_word, wordRanking.get(remote_word)+remote_timesFound);
            } else{
                // Add new word to the index
                wordRanking.put(remote_word,remote_timesFound);
            }
        }
    }

    public synchronized void setDocumentCharacters(int inputdata){
        documentCharactersTotal+=inputdata;
    }

    public void setDocumentSize(long inputdata){
        documentSize+=inputdata;
    }

    public void setDocumentCounter(){
        documentCounter++;
    }

    public int getWordcount(){
        return totalWords;
    }

    public int getDifferentWordcount(){
        return totalUniqueWords;
    }

    public long getDocumentSize(){
        return documentSize;
    }

    public int getDocumentCounter(){
        return documentCounter;
    }

    public int getAverageDocumentCharacters(){
        return documentCharactersTotal/documentCounter;
    }

    private void setTotalUniqueWords(){
        totalUniqueWords++;
    }
}
