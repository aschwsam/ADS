package p09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DocumentWordDetail {

    private HashMap<String, Integer> word_occurence_counter = new HashMap<>();
    private ArrayList<String> word_chain = new ArrayList<>();

    public DocumentWordDetail(){

    }

    public boolean containsWord(String needle){
        return word_occurence_counter.containsKey(needle);
    }

    public void addWord(String word){
        boolean foundWord = false;

        // Add to chain
        addWordChain(word);

        for(Map.Entry<String,Integer> wordmap : word_occurence_counter.entrySet()){
            if(wordmap.getKey().equals(word)){
                word_occurence_counter.put(wordmap.getKey(),wordmap.getValue()+1);
                return;
            }
        }

        // If we get to here the word wasn't found in dataset -> Add it
        word_occurence_counter.put(word,1);
    }

    private void addWordChain(String word){
        word_chain.add(word);
    }
}
