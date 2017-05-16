package p09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WordSearch {

    private HashMap<String,HashSet<String>> wordInDocument = new HashMap<String,HashSet<String>>();

    public WordSearch(){

    }

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

    public ArrayList<String> searchWord(String input){
        if(!input.equals("")){
            if(wordInDocument.containsKey(input)){
                ArrayList<String> result = new ArrayList<>();

                for(String files : wordInDocument.get(input)){
                    result.add(files);
                }

                return result;
            }
        }

        return null;
    }
}
