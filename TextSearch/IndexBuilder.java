package TextSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * IndexBuilder
 * ~~~~~~~~~~~~
 * @author stephan
 * @since 05.05.2016
 * @version 1.0
 *
 * Reads all or a subset of the Review Files, creates the Review objects and generates an Index.
 *
 */
public class IndexBuilder {
    //Set if you want to only index a subset of the reviews. E.g. "^A10A" matches all authors who start with 'A10A'
    public static final String REVIEWPATH = "/home/stephan/reviewsbymembers50000";
    private static final String SUBSET_PATHERN = "";//"^A10A";

    public static Index createIndex() throws FileNotFoundException {
        ArrayList<Review> reviews;
        reviews=readFiles();
        Index index =new Index();
        index.indexReviews(reviews);
        return index;
    }

    public static ArrayList<Review> readFiles() throws FileNotFoundException {
        ArrayList<Review> reviews=new ArrayList<>();
        File rootDirectory = new File(REVIEWPATH);
        for (File authorFolder : rootDirectory.listFiles()) {
            if (isInSubset(authorFolder)) {
                for (File reviewFile : authorFolder.listFiles()) {
                    Review review = new Review(reviewFile.getName(), authorFolder.getName());
                    review.scanFile(REVIEWPATH);
                    reviews.add(review);
                }
            }
        }
        return reviews;
    }


    /**
     * reduce the indexed folders to a subset to save time while debuging
     * @param authorFolder
     * @return
     */
    public static boolean isInSubset(File authorFolder) {
        Pattern p = Pattern.compile(SUBSET_PATHERN);
        Matcher m = p.matcher(authorFolder.getName());
        return m.find();
    }

}
