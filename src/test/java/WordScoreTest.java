import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordScoreTest {

    @Test
    public void testALowerCaseLetter() {
        WordScore scrabble = new WordScore("a");
        assertEquals(1, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAUpperCaseLetter() {
        WordScore scrabble = new WordScore("A");
        assertEquals(1, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAValuableLetter() {
        WordScore scrabble = new WordScore("f");
        assertEquals(4, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAShortWord() {
        WordScore scrabble = new WordScore("at");
        assertEquals(2, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAShortValuableWord() {
        WordScore scrabble = new WordScore("zoo");
        assertEquals(12, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAMediumWord() {
        WordScore scrabble = new WordScore("street");
        assertEquals(6, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAMediumValuableWord() {
        WordScore scrabble = new WordScore("quirky");
        assertEquals(22, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testALongMixCaseWord() {
        WordScore scrabble = new WordScore("OxyphenButazone");
        assertEquals(41, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAEnglishLikeWord() {
        WordScore scrabble = new WordScore("pinata");
        assertEquals(8, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAnEmptyInput() {
        WordScore scrabble = new WordScore("");
        assertEquals(0, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testEntireAlphabetAvailable() {
        WordScore scrabble = new WordScore("abcdefghijklmnopqrstuvwxyz");
        assertEquals(87, scrabble.getScore());
    }

}
