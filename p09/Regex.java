package p09;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Regex {

    private int exp_value_reading = 0;
    private ArrayList<String> commands = new ArrayList<>();
    private HashSet<Character> blacklist = new HashSet<>();
    private static HashMap<String,String> operator = new HashMap<>();

    /**
     * TODO: Remove this main
     */
    public static void main(String Args[]){
        Regex rg = new Regex();
        rg.parseExpression();
    }

    public Regex() {
        // Constructor

        blacklist.add('!');
        blacklist.add('(');
        blacklist.add(')');
        blacklist.add('"');

        operator.put("&&","AND");
        operator.put("||","OR");
        operator.put("*","BRACKET");
    }

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

            for(String expression_parts : commands){
                System.out.println('"'+expression_parts+'"');
                System.out.println("=======");
            }

            determineSituation();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void determineSituation(){
        switch(commands.size()){
            case 1:
                // Only one word -> 1st word positive
                //getPositiveDataset(commands.get(0),null);

                System.out.println("Positive one word");

                break;

            case 2:
                // 2 words OR 1st word negative
                if(commands.get(0).equals("!")){
                    //getNegativeDataset(commands.get(1),null);

                    System.out.println("Negative one word");

                } else {
                    //getPositiveDataset(commands.get(1),getPositiveDataset(commands.get(0),null));

                    System.out.println("Positive first word; Positive second word");

                }
                break;

            case 3:
                // 2 words one of the is negative
                if(commands.get(0).equals("!")){
                    // First one is negative

                    // get negative and pass subset to positive
                    //getPositiveDataset(commands.get(2),getNegativeDataset(commands.get(1),null));


                    System.out.println("Negative first word; Positive second word");

                } else {
                    // Second one is negative

                    // get dataset for positive
                    //getPositiveDataset(commands.get(0),getNegativeDataset(commands.get(2),null));

                    System.out.println("Positive first word; Negative second word");
                }
                break;

            case 4:
                // 2 words, both negative
                //getNegativeDataset(commands.get(1),null);

                System.out.println("Negative first word; Negative second word");

                break;
        }
    }

    private HashSet<String> getPositiveDataset(String needle,HashSet<String> knownRecords){
        HashSet<String> subset = new HashSet<>();

        if(knownRecords!=null) {

            // Search for needle in already selected documents
            for(String haystack : knownRecords){
                if(haystack.contains("OLD-SUBSET")){
                    subset.add("PATH-TO-FILE");
                }
            }
        } else {
            // Search through all documents

        }

        return subset;
    }

    private HashSet<String> getNegativeDataset(String needle,HashSet<String> knownRecords){
        HashSet<String> subset = new HashSet<>();

        if(knownRecords!=null){

            // Search for needle in already selected documents
            for(String haystack : knownRecords){
                if(!haystack.contains("OLD-SUBSET")){
                    subset.add("PATH-TO-FILE");
                }
            }
        } else {
            // Search through all documents
        }

        return subset;
    }
}
