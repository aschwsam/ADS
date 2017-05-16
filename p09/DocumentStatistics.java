package p09;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * This class holds global statistics
 * -> Average textsize is unique for each document
 */
public class DocumentStatistics {

    private long documentSize = 0;
    private int documentCounter = 0;
    private int totalWords = 0;
    private int totalUniqueWords = 0;
    private ConcurrentHashMap<String,String> uniqueWords = new ConcurrentHashMap<>();
    private HashMap<String,Integer> wordRanking = new HashMap<>();

    public DocumentStatistics(){

    }

    public synchronized void setWordcount(int wordcount){
        totalWords+=wordcount;
    }

    public synchronized void setDifferentWordcount(ConcurrentHashMap<String,String> inputdata){
        for(Map.Entry<String,String> word : inputdata.entrySet()){
            if(!uniqueWords.contains(word.getKey())){
                totalUniqueWords++;
                uniqueWords.put(word.getKey(),"");
            }
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

    public ConcurrentHashMap<String,String> getUniqueWords(){
        return uniqueWords;
    }

    public long getDocumentSize(){
        return documentSize;
    }

    public int getDocumentCounter(){
        return documentCounter;
    }
}
