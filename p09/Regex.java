package p09;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Regex {

    private int exp_value_reading = 0;
    private boolean conjunction = true;
    private String expression_words = null;
    private ArrayList<String> commands = new ArrayList<>();
    private HashSet<Character> blacklist = new HashSet<>();
    private HashSet<DocumentWordDetail> subset = new HashSet<>();
    private DocumentStatistics dcs;

    public Regex(DocumentStatistics dcs) {

        this.dcs = dcs;
        blacklist.add('!');
        blacklist.add('(');
        blacklist.add(')');
        blacklist.add('"');
    }

    /**
     * Reads a regular expression (String) as argument and returns all matching documents
     * @param user_expression String search term
     * @return ArrayList<String> path-to-file
     */
    public ArrayList<String> parseExpressionFromString(String user_expression){
        for(int i=0; i<user_expression.length(); i++) {
            createCommands(user_expression.charAt(i));
        }

        if(expression_words!=null){
            commands.add(expression_words);
        }

        // Run regex
        return determineSituation();
    }

    /**
     * Reads a regular expression from a file and returns all matching documents
     * TODO: Switch from hard coded link to user argument
     * @return ArrayList<String> path-to-file
     */
    public ArrayList<String> parseExpressionFromFile(){
        try {
            InputStream in = new FileInputStream("C:\\Users\\Sam\\Desktop\\ADS_Regex\\expression.txt");
            Reader reader = new InputStreamReader(in, "UTF-8");
            Reader buffer = new BufferedReader(reader);

            int r;
            while ((r = buffer.read()) != -1) {
                createCommands((char) r);
            }

            if(expression_words!=null){
                commands.add(expression_words);
            }

            // Run regex
            return determineSituation();

        } catch (IOException e){
            e.printStackTrace();

            return null;
        }
    }

    /**
     * Check if one or two words are used
     * Check if any of them are a inverted (!)
     * Merge the subsets
     * @return ArrayList<String> result set
     */
    private ArrayList<String> determineSituation(){

        // Strip "&&" / "||" from String
        ArrayList<String> positive_or_negative = new ArrayList<>();
        for(String value : commands){
            if(!value.equals("&&") && !value.equals("||")){
                positive_or_negative.add(value);
            }
        }

        // Default operation is && => conjunction = true;
        if(commands.contains("||")){
            conjunction = false;
        }

        switch(positive_or_negative.size()){
            case 1:
                // Only one word -> 1st word positive
                getPositiveDataset(positive_or_negative.get(0));
                break;

            case 2:
                // 2 words OR 1st word negative
                if(positive_or_negative.get(0).equals("!")){
                    getNegativeDataset(positive_or_negative.get(1));
                } else {
                    getPositiveDataset(positive_or_negative.get(1));
                    getPositiveDataset(positive_or_negative.get(0));
                }
                break;

            case 3:
                // 2 words one of the is negative
                if(positive_or_negative.get(0).equals("!")){
                    // First one is negative

                    // get negative and pass subset to positive
                    getPositiveDataset(positive_or_negative.get(2));
                    getNegativeDataset(positive_or_negative.get(1));
                } else {
                    // Second one is negative

                    // get dataset for positive
                    getPositiveDataset(positive_or_negative.get(0));
                    getNegativeDataset(positive_or_negative.get(2));
                }
                break;

            case 4:
                // 2 words, both negative
                getNegativeDataset(positive_or_negative.get(1));
                getNegativeDataset(positive_or_negative.get(3));
                break;
        }

        // Convert ArrayList from subset and return
        ArrayList<String> resultset = new ArrayList<>();
        Iterator<DocumentWordDetail> it = subset.iterator();
        while(it.hasNext()){
            resultset.add(it.next().getPath());
            //System.out.println("Expression matched in file "+it.next().getPath());
        }

        return resultset;
    }

    /**
     * Creates a ArrayList with each word/expression depending on the current position.
     * Eg. '"lorem ipsum"' is one word and 'lorem ipsum' are two words because of the missing quotation mark
     * @param input char
     */
    private void createCommands(char input){

        switch(input){
            case '!':
                commands.add("!");
                exp_value_reading = 1;
                break;

            case ' ':
                if(exp_value_reading == 1){

                    // Stop reading
                    exp_value_reading = 0;
                }
                break;

            case '"':
                if(exp_value_reading == 2){
                    exp_value_reading = 0;
                } else {
                    exp_value_reading = 2;
                }
                break;

            case '(':
                exp_value_reading = 3;
                commands.add("*");
                break;

            case ')':
                exp_value_reading = 0;
                break;

            default:
                if(exp_value_reading == 0){
                    exp_value_reading = 1;
                }
                break;
        }

        if(exp_value_reading>0){

            if(!blacklist.contains(input)){
                if(expression_words == null){
                    expression_words = String.valueOf(input);
                } else {
                    expression_words += String.valueOf(input);
                }
            }
        } else {
            if(expression_words != null){

                // Splitt on || or &&
                if(expression_words.contains(" || ") || expression_words.contains(" && ")){
                    for(String parts : expression_words.split(" ")){
                        commands.add(parts);
                    }
                } else {
                    commands.add(expression_words);
                }

                if(input == ')'){
                    commands.add("*");
                }

                expression_words = null;
            }
        }
    }

    /**
     * Creates or modifies a subset of files which DO contain the search term
     * @param needle String searchterm
     */
    private void getPositiveDataset(String needle){

        if(subset.size()>0 && conjunction) {

            // Search for needle in already selected documents
            Iterator<DocumentWordDetail> it = subset.iterator();
            while(it.hasNext()) {

                DocumentWordDetail dwd = it.next();

                if(!dwd.containsWord(needle)) {
                    // Remove from subset
                    it.remove();
                }
            }
        } else {
            // Search through all documents
            for(DocumentWordDetail dwd : dcs.getDocumentWordDetail()){
                if(dwd.containsWord(needle)){
                    subset.add(dwd);
                }
            }
        }
    }

    /**
     * Creates or modifies a subset of files which DO NOT contain the search term
     * @param needle String searchterm
     */
    private void getNegativeDataset(String needle){

        if(subset.size()>0 && conjunction){

            Iterator<DocumentWordDetail> it = subset.iterator();
            while(it.hasNext()){
                DocumentWordDetail dwd = it.next();

                if(dwd.containsWord(needle)){
                    // Remove from subset
                    it.remove();
                }
            }
        } else {
            // Search through all documents
            for(DocumentWordDetail dwd : dcs.getDocumentWordDetail()){
                if(!dwd.containsWord(needle)){
                    subset.add(dwd);
                }
            }
        }
    }
}
