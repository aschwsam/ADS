package marathon;


import org.junit.*;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by stephan on 16.03.17.
 */
public class CompetitorTest {
    private Competitor stephan;
    private Competitor stephan2;
    private Competitor sam;


    @Before
    public void setUp() throws ParseException {
        stephan = new Competitor(123, "Stephan", "Graf", 1992, "Winterthur", "02:54:06.3");
        stephan2 = new Competitor(123, "Stephan", "Graf", 1992, "Winterthur", "02:54:06.3");
        sam = new Competitor(123, "Sam", "Aschwanden", 1992, "Winterthur", "02:54:06.4");
    }


    @Test
    public void shouldcorrectlyCompareBiggerToSmaller() {
        assertTrue(stephan.compareTo(sam) > 0);
        assertFalse(stephan.compareTo(sam) == 0);
    }

    @Test
    public void shouldbeSame(){
        assertTrue(stephan.compareTo(stephan) == 0);
    }

    @Test
    public void shouldConvertToString() {
        System.out.println(stephan.toString());
    }
}
