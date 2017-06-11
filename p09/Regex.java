package p09;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Regex {

    private int exp_value_reading = 0;
    private boolean conjunction = true;
    private ArrayList<String> commands = new ArrayList<>();
    private HashSet<Character> blacklist = new HashSet<>();
    HashSet<DocumentWordDetail> subset = new HashSet<>();
    private DocumentStatistics dcs;

    /**
     * TODO: Remove this main
     */
    public static void main(String Args[]){
        Regex rg = new Regex(new DocumentStatistics());
        rg.parseExpression();
    }

    public Regex(DocumentStatistics dcs) {
        // Constructor

        this.dcs = dcs;

        blacklist.add('!');
        blacklist.add('(');
        blacklist.add(')');
        blacklist.add('"');
    }

    /**
     * Reads a file with a regular expression ((!)Word 1 &&|| (!)Word 2)
     * Generates a list of all files that match the regex
     */
    public void parseExpression(){
        try {
            InputStream in = new FileInputStream("C:\\Users\\Sam\\Desktop\\ADS_Regex\\expression.txt");
            Reader reader = new InputStreamReader(in, "UTF-8");
            Reader buffer = new BufferedReader(reader);

            int r;
            char input;
            String expression = null;
            while ((r = buffer.read()) != -1) {
                input = (char) r;

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
                        if(expression == null){
                            expression = String.valueOf(input);
                        } else {
                            expression += String.valueOf(input);
                        }
                    }
                } else {
                    if(expression != null){

                        // Splitt on || or &&
                        if(expression.contains(" || ") || expression.contains(" && ")){
                            for(String parts : expression.split(" ")){
                                commands.add(parts);
                            }
                        } else {
                            commands.add(expression);
                        }

                        if(input == ')'){
                            commands.add("*");
                        }
                        expression = null;
                    }
                }
            }

            if(expression!=null){
                commands.add(expression);
            }

            // TODO: Remove this debug loop
            for(String expression_parts : commands) {
                System.out.println('"' + expression_parts + '"');
                System.out.println("=======");
            }

            determineSituation();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Check if one or two words are used, then check if any of them are a inverted (!)
     */
    private void determineSituation(){

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

        // Print the files
        Iterator<DocumentWordDetail> it = subset.iterator();
        while(it.hasNext()){
            System.out.println("########### "+it.next().getPath());
        }
    }

    /**
     * Loop over given files and remove files from list if needle is not present
     * @param needle
     * @return
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

        Iterator<DocumentWordDetail> asd = subset.iterator();
        while(asd.hasNext()){
            System.out.println("==> "+asd.next().getPath());
        }
    }

    /**
     * If a given subset contains files, remove files which contain the needle
     * @param needle (search term)
     * @return HashSet with files
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

        Iterator<DocumentWordDetail> asd = subset.iterator();
        while(asd.hasNext()){
            System.out.println("==> "+asd.next().getPath());
        }
        System.out.println("======");
    }
}
