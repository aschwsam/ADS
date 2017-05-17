package TextSearch;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

/**
 * Created by stephan on 06.05.2016.
 */
public class ReviewTest {
    String basePath = "H:\\Schule\\zhaw\\02\\ADS\\P11\\reviewsbymembers50000";

    @Before
    public void setUp() {
    }


    @Test
    public void shouldCreateReview() throws Exception {
        String author = "A10A0MBFUQ3V81";
        String title = "A Christian Classic.txt";
        Review review = new Review(title, author);
        assertEquals(author, review.getAuthor());
        assertEquals(title, review.getTitle());
    }

    @Test
    public void shouldScanFileCorrectly() throws FileNotFoundException {
        String author = "A10A0MBFUQ3V81";
        String title = "A Christian Classic.txt";
        Review review = new Review(title, author);
        review.scanFile(basePath);
        assertEquals(review.getContent(), " This book is a must read for all Christians.  It discussed the foundation behind real Christianity.  This book can be read over and over again, while learning something new each time.     ");
    }

@Test
    public void shouldCountWordsCorrectly() throws FileNotFoundException {
        String author = "A10A0MBFUQ3V81";
        String title = "A Christian Classic.txt";
        Review review = new Review(title, author);
        review.scanFile(basePath);
        System.out.println(review.getWords());
        assertEquals(31, review.getWordCount());
    }
}
