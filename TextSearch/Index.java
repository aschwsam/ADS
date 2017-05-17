package TextSearch;


import java.util.ArrayList;
import java.util.HashMap;


/**
 * Index
 * ~~~~~~~~~~~~
 *
 * @author stephan
 * @version 1.0
 *          contains a list of words and for every word a list of reviews in which it is contained.
 * @since 11.05.2017
 */
public class Index {
    private HashMap<String, ArrayList<Review>> index = new HashMap<>();
    private int totalSize;
    private int numberOfDocuments = 1;
    private int wordCount = 1;
    private int distinctWordCount = 1;
    private int totalTextlength = 1;


    public void printStatistics() {
        System.out.println("~~~~~~~~~ Statistics ~~~~~~~~~~");
        System.out.println("totals: ");
        System.out.printf("Number of documents: " + numberOfDocuments + "\n");
        System.out.printf("Total Size of all Documents: " + totalSize + " MB\n");
        System.out.printf("Total Word count: " + wordCount + "\n");
        System.out.printf("Total Distinct Word count: " + distinctWordCount + "\n");
        System.out.println("averages: ");
        System.out.println("Average Document Size: " + totalSize / numberOfDocuments);
        System.out.println("Average Word count: " + wordCount / numberOfDocuments);
        System.out.printf("Average Distinct Word count: " + distinctWordCount / numberOfDocuments);
        System.out.printf("Average Text Length: " + totalTextlength / numberOfDocuments + "\n");
    }


    public ArrayList<Review> search(String word, boolean caseSensitive) throws NoResultsException {
        ArrayList<Review> reviews;
        if (index.containsKey(word)) {
            reviews = index.get(word);
        } else {
            throw new NoResultsException();
        }
        //TODO:make unique
        // HashMap<Review,Integer> results =reviews;
        // addLengthPoints(results);
        return reviews;
    }


    public void indexReviews(ArrayList<Review> reviews) {
        for (Review review : reviews) {
            for (String word : review.getWords()) {
                if (index.containsKey(word)) {
                    index.get(word).add(review);
                } else {
                    ArrayList<Review> newReviews = new ArrayList<>();
                    newReviews.add(review);
                    index.put(word, newReviews);
                    distinctWordCount++;
                }
                wordCount++;
                totalTextlength += word.length();
            }
        }
    }


    /**
     * Print all the words and in which reviews each is contained.
     *
     * @return List of all the words in the index
     */
    public String toString() {
        String result = "";
        for (String word : index.keySet()) {
            result += word + " (" + index.get(word).toString() + ")\n";
        }
        return result;
    }
}
