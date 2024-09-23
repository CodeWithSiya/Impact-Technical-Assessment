import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * The WordScore class computes the Scrabble score for a given word based on the Scrabble point system.
 * This class provides functionality to calculate and obtain the total score of a given word.
 * 
 * It assigns values to letters according to the following system.
 * Letter                           Value
 * A, E, I, O, U, L, N, R, S, T       1
 * D, G                               2
 * B, C, M, P                         3
 * F, H, V, W, Y                      4
 * K                                  5
 * J, X                               8
 * Q, Z                               10
 * 
 * Extensions: Allow the user to specify letter and word multipliers.
 * 
 * @author Siyabonga Madondo
 * @version 23/09/2024
 */

public class WordScore 
{
    /** 
     * A HashMap that stores the Scrabble point values for different letter categories.
     * The keys are arrays of letters, and the values represent the point value of those letters.
     */
    private static HashMap<ArrayList<String>, Integer> points;

    /** 
     * Stores the total score for the word being processed. 
     */
    private int score;

    /**
     * Create a new WordScore object from the given word and compute its score.
     * @param word The word which the Scrabble score needs to be computed for.
     */
    public WordScore(String word) {
        WordScore.initialisePointSystem();
        this.score = WordScore.computeScore(word);
    }

    /**
     * Create a new WordScore object from the given word and compute its score with multipliers.
     * @param word The word which the Scrabble score needs to be computed for.
     * @param letterMultipliers An array of integers representing multipliers for each letter.
     * @param wordMultiplier The multiplier for the entire word score.
     */
    public WordScore(String word, int[] letterMultipliers, int[] wordMultiplier) {
        WordScore.initialisePointSystem();
        this.score = WordScore.computeScore(word, letterMultipliers, wordMultiplier);
    }

    /**
     * Initialises the letter categories and their corresponding Scrabble point values.
     */
    private static void initialisePointSystem() {
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
     * Computes the Scrabble score for the given word.
     * @param word The word which the Scrabble score needs to be computed for.
     * @return The total score for the given word.
     */
    private static int computeScore(String word) {
        // Initialise the score to zero.
        int score = 0;
        // Loop through each character of the word to obtain the score.
        for (int i = 0; i < word.length(); i++) {
            // Obtain the current letter from the word and convert it to uppercase.
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
     * Computes the Scrabble score for the given word with letter and word multipliers.
     * @param word The word for which the Scrabble score needs to be computed.
     * @param letterMultipliers An array of integers representing multipliers for each letter.
     * @param wordMultiplier The multiplier for the entire word score.
     * @return The total score for the given word after applying multipliers.
     * @throws IllegalArgumentException if the length of letterMultipliers doesn't match the word length
     */
    private static int computeScore(String word, int[] letterMultipliers, int wordMultiplier) throws IllegalArgumentException {
        // Check if the length of letterMultipliers matches the word length.
        if (word.length() != letterMultipliers.length) {
            throw IllegalArgumentException("Length of letterMultipliers must match the word length");
        } 
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
                    // Add the corresponding multiplied point value and exit the inner loop.
                    score += points.get(category) * letterMultipliers[i];
                    break; 
                }
            }
        }
        return score * wordMultiplier;
    }

    /**
     * Obtain the score for the current word.
     * @return  The total Scrabble score for the current word.
     */
    public int getScore() {
        return this.score;
    }
}