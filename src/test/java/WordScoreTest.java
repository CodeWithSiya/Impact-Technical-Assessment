import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.beans.Transient;

public class WordScoreTest {

    @Test
    public void testALowerCaseLetter() {
        WordScore scrabble = new WordScore("a");
        assertEquals(1, scrabble.getScore());
    }

    @Test
    public void testAUpperCaseLetter() {
        WordScore scrabble = new WordScore("A");
        assertEquals(1, scrabble.getScore());
    }

    @Test
    public void testAValuableLetter() {
        WordScore scrabble = new WordScore("f");
        assertEquals(4, scrabble.getScore());
    }

    @Test
    public void testAShortWord() {
        WordScore scrabble = new WordScore("at");
        assertEquals(2, scrabble.getScore());
    }

    @Test
    public void testAShortValuableWord() {
        WordScore scrabble = new WordScore("zoo");
        assertEquals(12, scrabble.getScore());
    }

    @Test
    public void testAMediumWord() {
        WordScore scrabble = new WordScore("street");
        assertEquals(6, scrabble.getScore());
    }

    @Test
    public void testAMediumValuableWord() {
        WordScore scrabble = new WordScore("quirky");
        assertEquals(22, scrabble.getScore());
    }

    @Test
    public void testALongMixCaseWord() {
        WordScore scrabble = new WordScore("OxyphenButazone");
        assertEquals(41, scrabble.getScore());
    }

    @Test
    public void testAEnglishLikeWord() {
        WordScore scrabble = new WordScore("pinata");
        assertEquals(8, scrabble.getScore());
    }

    @Test
    public void testAnEmptyInput() {
        WordScore scrabble = new WordScore("");
        assertEquals(0, scrabble.getScore());
    }

    @Test
    public void testEntireAlphabetAvailable() {
        WordScore scrabble = new WordScore("abcdefghijklmnopqrstuvwxyz");
        assertEquals(87, scrabble.getScore());
    }

    @Test
    public void testWithDoubleLetterScore() {
        WordScore scrabble = new WordScore("hello", new int[]{1, 2, 1, 1, 1}, 1);
        assertEquals(9, scrabble.getScore()); // 'e' is doubled.
    }

    @Test
    public void testWithTripleLetterScore() {
        WordScore scrabble = new WordScore("zoo", new int[]{1, 1, 3}, 1);
        assertEquals(14, scrabble.getScore()); // 'o' is tripled
    }

    @Test
    public void testWithDoubleWordScore() {
        WordScore scrabble = new WordScore("quick", new int[]{1, 1, 1, 1, 1}, 2);
        assertEquals(40, scrabble.getScore()); // whole word is doubled
    }

    @Test
    public void testWithTripleWordScore() {
        WordScore scrabble = new WordScore("quick", new int[]{1, 1, 1, 1, 1}, 3);
        assertEquals(60, scrabble.getScore()); // whole word is tripled
    }

    @Test
    public void testComplexScoring() {
        WordScore scrabble = new WordScore("quixotic", new int[]{1, 1, 1, 2, 1, 1, 1, 3}, 2);
        assertEquals(80, scrabble.getScore()); // 'x' doubled, 'c' tripled, whole word doubled
    }
}