package p09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WordSearch {

    private HashMap<String,HashSet<String>> wordInDocument = new HashMap<String,HashSet<String>>();

    public WordSearch(){

    }

    /**
     * Creates a Map which contains all words and there sources
     * @param words every word from a specific document
     * @param pathToFile path to document of "words"
     */
    public synchronized void addWordInDocument(HashMap<String,Integer> words, String pathToFile){
        for(Map.Entry<String,Integer> entry : words.entrySet()){

            // Check if word is in index
            if(wordInDocument.containsKey(entry.getKey())){

                // Check if the word has been mapped to current file already
                if(!wordInDocument.get(entry.getKey()).contains(pathToFile)){
                    wordInDocument.get(entry.getKey()).add(pathToFile);
                }
            } else {
                // Create a new entry for the word
                HashSet<String> tmp = new HashSet<>();
                tmp.add(pathToFile);
                wordInDocument.put(entry.getKey(),tmp);
            }
        }
    }

    /**
     * Search for a single word in map
     * @param input the search term
     * @return ArrayList with path to files containing the word
     */
    public ArrayList<String> searchWord(String input){
        ArrayList<String> result = new ArrayList<>();

        if(!input.equals("")){
            if(wordInDocument.containsKey(input)){
                result.addAll(wordInDocument.get(input));
                return result;
            }
        }

        return result;
    }
}
