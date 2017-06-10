package p09;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Regex {

    private ArrayList<String> commands = new ArrayList<>();
    private int exp_value_reading = 0;
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

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void asd(){

    }

}
