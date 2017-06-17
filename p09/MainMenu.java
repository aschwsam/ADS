package p09;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A simple main menu for the script ( console based)
 * the script can also be started via console parameter (Threadmaster class)
 */
public class MainMenu {

    // Options for the parser
    private static int threadCount = 4;
    private static int wordRankingDepth = 5;
    private static boolean wordRanking = true;
    private static boolean statistics = true;
    private static String searchTerm = null;
    private static String searchPath = null;
    private static String sourceFilesPath = null;

    // Options for menu
    private static ThreadMaster tm;
    private static boolean tmRunning = false;
    private static int tempNumber = 1;
    private static String tempText = null;

    // Options for main menu status
    private static final int RUN = 7;
    private static final int EXIT = 8;


    public static void main(String Args[]){

        System.out.println("=======================================");
        System.out.println("This is a simple text parsing script");
        System.out.println("Please select one of the options bellow");
        System.out.println("=======================================");

        int user_selection = displayMenu();

        while(user_selection != EXIT){
            System.out.println("You selected "+user_selection);

            switch(user_selection){
                case 1:
                    setThreads();
                    break;

                case 2:
                    toggleWordRanking();
                    break;

                case 3:
                    toggleStatistics();
                    break;

                case 4:
                    setWordRankingDepth();
                    break;

                case 5:
                    setSourcePath();
                    break;

                case 6:
                    setSearchTerm("a word or regular expression");
                    if(tmRunning){
                        tm.searchWord(searchTerm);
                    }
                    break;

                /*
                case 7:
                    setSearchPath("a path to the file");
                    break;
                */
                case RUN:
                    if(!tmRunning){
                        if(sourceFilesPath!=null){
                            tm = new ThreadMaster(threadCount, wordRanking, wordRankingDepth, statistics, searchTerm, sourceFilesPath);
                        } else {
                            System.out.println("Please set the path to the source files first!");
                        }

                        tmRunning = true;
                    }
                    break;

                default:

                    break;
            }

            // Display menu
            user_selection = displayMenu();
        }
    }

    /**
     * Print the available options
     * @return int user selected part of the script to be run
     */
    private static int displayMenu(){
        System.out.println();
        System.out.println("Program specific options");
        System.out.println("1 - Set amount of threads ("+threadCount+")");
        System.out.println("2 - Toggle word ranking ("+wordRanking+")");
        System.out.println("3 - Toggle statistics ("+statistics+")");
        System.out.println("4 - Set word ranking depth ("+wordRankingDepth+")");
        System.out.println("5 - Set path to source files ('"+sourceFilesPath+"')");
        System.out.println("Runtime options");
        System.out.println("6 - Enter an expression / word to search for in files ('"+searchTerm+"')");
        //System.out.println("7 - Enter a path to a file containing an expression to search for in files ('"+searchPath+"')");
        System.out.println(RUN+" - Run parser");
        System.out.println(EXIT+" - Exit");
        System.out.println();

        return numberScanner();
    }

    /**
     * Reads an integer number from the console
     * @return int user value
     */
    private static int numberScanner(){
        Scanner input = new Scanner(System.in);

        try{
            return input.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Please enter an integer value");
            return 0;
        }
    }

    /**
     * Reads a String from the console
     * @return String uservalue
     */
    private static String textScanner(){

        Scanner input = new Scanner(System.in);
        try{
            return input.nextLine();
        } catch (InputMismatchException e){
            System.out.println("Something went wrong");
            return null;
        }
    }

    /**
     * Proxy for textScanner and method requiring a String value from user
     * @param directions String description of value user should input
     * @return boolean true if new value should be picked up, false if user cancelled action
     */
    private static boolean textHandler(String directions){
        System.out.println("Please enter a "+directions);
        System.out.println("\tTo reset the search term enter 'null'");
        System.out.println("\tTo leave without changing your previous input, just press return");

        String ts = textScanner();

        if(ts.equals("null")){
            tempText = null;
            return true;
        } else {
            if(ts.length()>0){
                tempText = ts;
                return true;
            }
        }

        return false;
    }

    /**
     * Proxy for numberScanner and method requiring a int value from user
     * @return boolean true if new value should be picked up, false if user cancelled action
     */
    private static boolean numberHandler(){
        System.out.println("Please enter a number > 0");

        int ns = numberScanner();

        while(ns<=0){
            if(ns == -123){
                return false;
            } else {
                System.out.println("Please enter a number > 0 or -123 to return to the main menu");
                ns = numberScanner();
            }
        }

        tempNumber = ns;
        return true;
    }

    /**
     * Set the amount of threads to spawn
     */
    private static void setThreads(){
        if(numberHandler()){
            threadCount = tempNumber;
        }
        return;
    }

    /**
     * Switch word ranking display (on / off)
     */
    private static void toggleWordRanking(){
        wordRanking ^=true;
        return;
    }

    /**
     * Switch document detail statistics display (on / off)
     */
    private static void toggleStatistics(){
        statistics ^=true;
        return;
    }

    /**
     * Define how long the top X should be
     */
    private static void setWordRankingDepth(){
        if(numberHandler()){
            wordRankingDepth = tempNumber;
        }
        return;

    }

    /**
     * Set the user search expression
     */
    private static void setSearchTerm(String directions){
        if(textHandler(directions)){
            searchTerm = tempText;
        }

        return;
    }

    /**
     * Set the path to look for user search expression
     */
    private static void setSearchPath(String directions){
        if(textHandler(directions)){
            searchPath = tempText;
        }

        return;
    }

    /**
     * Set path to source files the parser should read
     */
    private static void setSourcePath(){
        if(textHandler("path to the source files")){
            sourceFilesPath = tempText;
        }

        return;
    }
}
