package TextSearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class TextSearch {
    public static final boolean DEBUG = true;
    public static final String HEADER_TEXT = "~~~~~~~~~~~~~ TextSearch ~~~~~~~~~~~~~~~~~\n\nType 'quit' to exit " +
          "program \n\n┌───────────────────────────────────\n│ SEARCH: ";
    private Index index;


    public static void main(String[] args) throws IOException {
        new TextSearch();
    }

    public TextSearch() throws IOException {
        index = IndexBuilder.createIndex();
        index.printStatistics();
        //if(DEBUG){System.out.println("\n\nIndex:\n~~~~~~~~\n" + index.toString());}
        readQueryContinuosly();
    }


    public HashMap<Review, Integer> makeUnique(ArrayList<Review> reviews) {
        HashMap<Review, Integer> results = new HashMap<>();
        for (Review review : reviews) {
            if (results.containsKey(review)) {
                results.put(review, results.get(review) + 1);
            } else {
                results.put(review, 0);
            }
        }
        return results;
    }


    public String getTitles(ArrayList<Review> reviews) {
        String[] titles = new String[reviews.size()];
        int i = 0;
        for (Review review : reviews) {
            titles[i] = review.getTitle();
            i++;
        }
        StringBuilder builder = new StringBuilder();
        for (String s : titles) {
            builder.append(s);
        }
        return builder.toString();
    }


    public void readQueryContinuosly() throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String word = "";
        while (!word.equals("quit") && word != null) {
            if (!DEBUG) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
            System.out.printf(HEADER_TEXT);
            word = console.readLine();
            if (!word.equals("quit")) {
                try {
                    ArrayList<Review> result = index.search(word, false);
                    System.out.println(getTitles(result));
                } catch (NoResultsException e) {
                    System.out.println("no results");
                }
            } else {
                System.out.println("byebye");
            }
        }
    }
}
