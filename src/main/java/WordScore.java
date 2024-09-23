import java.util.HashMap;

/**
 * The WordScore class computes the Scrabble score for a given word based on the Scrabble point system.
 * It assigns values to letters according to the following system:
 * 
 * Letter                           Value
 * A, E, I, O, U, L, N, R, S, T       1
 * D, G                               2
 * B, C, M, P                         3
 * F, H, V, W, Y                      4
 * K                                  5
 * J, X                               8
 * Q, Z                               10
 * 
 * @author Siyabonga Madondo
 * @version 23 September 2024
 */

public class WordScore 
{
    /** 
     * A HashMap that stores the Scrabble point values for different groups of letters.
     * The keys are arrays of letters, and the values represent the point value of those letters.
     */
    private HashMap<String[], Integer> points;

    /** 
     * Stores the total score for the word being processed. 
     */
    private int score;

    WordScore(String word) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    int getScore() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}