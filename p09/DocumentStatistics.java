package p09;

import java.util.ArrayList;
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
    private ArrayList<DocumentWordDetail> documentWordObject = new ArrayList<>();

    public DocumentStatistics(){

    }

    /**
     * Increments counter for amount of words found in all documents
     * @param wordcount
     */
    public synchronized void setWordcount(int wordcount){
        totalWords+=wordcount;
    }

    /**
     * Check if given word is unique over all documents.
     * @param inputdata
     */
    public synchronized void setUniqueWord(String inputdata){
        if(!uniqueWords.contains(inputdata)){

            // TODO: Remove debug
            //System.out.println(inputdata);

            setTotalUniqueWords();
            uniqueWords.add(inputdata);
        }
    }

    /**
     * Updates word occurrence over all documents
     * @param inputdata Map containing word / occurrence
     */
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

    /**
     * Updates character counter over all documents
     * @param inputdata current document characters
     */
    public synchronized void setDocumentCharacters(int inputdata){
        documentCharactersTotal+=inputdata;
    }

    /**
     * Adds a new DocumentWordDetail Object to the global list
     * @param node
     */
    public synchronized void addDocumentWordDetail(DocumentWordDetail node){ documentWordObject.add(node); }

    /**
     * Get the document word object list
     * @return DocumentWordDetail Arraylist
     */
    public synchronized ArrayList<DocumentWordDetail> getDocumentWordDetail(){ return documentWordObject; }

    /**
     * Updates total document size
     * @param inputdata current document size
     */
    public void setDocumentSize(long inputdata){
        documentSize+=inputdata;
    }

    /**
     * Increases the document counter
     */
    public void setDocumentCounter(){
        documentCounter++;
    }

    /**
     * Returns the total of words found in files
     * @return word counter (int)
     */
    public int getWordcount(){
        return totalWords;
    }

    /**
     * Returns total of unique words found
     * @return unique word counter (int)
     */
    public int getDifferentWordcount(){
        return totalUniqueWords;
    }

    /**
     * Returns total document size (in KB)
     * @return document size (String)
     */
    public String getDocumentSize(){
        if(documentSize>1000000){
            // MB
            return documentSize/1048576+" MB";
        } else {
            if(documentSize>1024){
                // KB
                return documentSize/1024+" KB";
            } else {
                // Byte
                return documentSize+" Byte";
            }
        }
    }

    /**
     * Returns the amount of processed documents
     * @return amount of documents (int)
     */
    public int getDocumentCounter(){
        return documentCounter;
    }

    /**
     * Returns the average characters per document
     * @return average of characters (int)
     */
    public int getAverageDocumentCharacters(){
        return documentCharactersTotal/documentCounter;
    }

    /**
     * Returns the wordRanking Map for BTree generation
     * @return HashMap containing word / occurrence
     */
    public HashMap<String,Integer> getWordRanking(){
        return wordRanking;
    }

    /**
     * Increments the unique word counter
     */
    private void setTotalUniqueWords(){
        totalUniqueWords++;
    }
}
