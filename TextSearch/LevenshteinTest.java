package TextSearch;


import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


/**
 * @author Stephan Graf
 * @since 11.05.17
 */
public class LevenshteinTest {
    @Test
    public void shouldHaveDistanceOne(){
        assertTrue(Levenshtein.haveDistanceOne("it", "sit"));
        assertTrue(Levenshtein.haveDistanceOne("it", "ist"));
        assertTrue(Levenshtein.haveDistanceOne("it", "its"));
        assertFalse(Levenshtein.haveDistanceOne("it", "it"));
        assertFalse(Levenshtein.haveDistanceOne("it", "i"));
        assertFalse(Levenshtein.haveDistanceOne("it", "itss"));
        assertFalse(Levenshtein.haveDistanceOne("it", "ssit"));
        assertFalse(Levenshtein.haveDistanceOne("it", "sits"));
        assertFalse(Levenshtein.haveDistanceOne("i", "2D"));
        assertFalse(Levenshtein.haveDistanceOne("i", "d"));
        assertFalse(Levenshtein.haveDistanceOne("i", "d"));
        assertTrue(Levenshtein.haveDistanceOne("", "a"));
        assertTrue(Levenshtein.haveDistanceOne("", "b"));
        assertTrue(Levenshtein.haveDistanceOne("", "�"));
        assertFalse(Levenshtein.haveDistanceOne("a", ""));
        assertFalse(Levenshtein.haveDistanceOne("", ""));
    }

    }
}
