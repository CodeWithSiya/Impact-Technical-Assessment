import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * The WordScore class computes the Scrabble score for a given word based on the Scrabble point system.
 * This class provides functionality to calculate and obtain the total score of a given word.
 * 
 * It assigns values to letters according to the following system:
 * Letter                           Value
 * A, E, I, O, U, L, N, R, S, T       1
 * D, G                               2
 * B, C, M, P                         3
 * F, H, V, W, Y                      4
 * K                                  5
 * J, X                               8
 * Q, Z                               10
 * 
 * Extentions: Allow the user to specify double or triple letters/words.
 * 
 * @author Siyabonga Madondo
 * @version 23/09/2024
 */

public class WordScore 
{
    /** 
     * A HashMap that stores the Scrabble point values for different groups of letters.
     * The keys are arrays of letters, and the values represent the point value of those letters.
     */
    private static HashMap<ArrayList<String>, Integer> points;

    /** 
     * Stores the total score for the word being processed. 
     */
    private int score;

    /**
     * Constants for the double and triple letter multipliers.
     */
    private static final int DOUBLE_LETTER = 2;
    private static final int TRIPLE_LETTER = 3;
 
    /**
     * Constants for the double and triple word multipliers.
     */
    private static final int DOUBLE_WORD = 2;
    private static final int TRIPLE_WORD = 3;

    /**
     * Create a new WordScore object from the given word and compute it's score.
     * @param word The word which the Scrabble score needs to be computed for.
     */
    public WordScore(String word) {
        // Initialise the point system and the score for the current word.
        WordScore.initialisePointSystem();
        // Compute the score for the current word and set the score.
        this.score = WordScore.computeScore(word);
    }

    /**
     * Initialises the letter categories and their corresponding Scrabble point values.
     */
    private static void initialisePointSystem() {
        // Initialise the points HashMap.
        points = new HashMap<>();
        // Add each letter group and their corresponding point values to the points HashMap.
        points.put(new ArrayList<>(Arrays.asList("A", "E", "I", "O", "U", "L", "N", "R", "S", "T")), 1);
        points.put(new ArrayList<>(Arrays.asList("D", "G")), 2);
        points.put(new ArrayList<>(Arrays.asList("B", "C", "M", "P")), 3);
        points.put(new ArrayList<>(Arrays.asList("F", "H", "V", "W", "Y")), 4);
        points.put(new ArrayList<>(Arrays.asList("K")), 5);
        points.put(new ArrayList<>(Arrays.asList("J", "X")), 8);
        points.put(new ArrayList<>(Arrays.asList("Q", "Z")), 10);
    }

    /**
     * Utility method which computes the Scrabble score for the given word.
     * @param word The word which the Scrabble score needs to be computed for.
     * @return The total score for the given word.
     */
    private static int computeScore(String word) {
        // Initialise the score to zero.
        int score = 0;
        // Loop through each character of the word to obtain the score.
        for (int i = 0; i < word.length(); i++) {
            // Obtain the current letter from the word.
            String letter = word.substring(i, i+1).toUpperCase();
            // Loop through each category in the points HashMap.
            for (ArrayList<String> category : points.keySet()) {
                // Check if the current category contains the current letter.
                if (category.contains(letter)) {
                    // Add the corresponding point value and exit the inner loop.
                    score += points.get(category);
                    break; 
                }
            }
        }
        return score;
    }
    
    /**
     * Obtain the score for the current word.
     * @return  The total Scrabble score for the current word.
     */
    public int getScore() {
        return this.score;
    }
}