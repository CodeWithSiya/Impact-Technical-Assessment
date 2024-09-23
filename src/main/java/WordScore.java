import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

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
    private static HashMap<ArrayList<String>, Integer> points;

    /** 
     * Stores the total score for the word being processed. 
     */
    private int score;

    /**
     * Initialises the letter categories and their corresponding Scrabble point values.
     */
    private void initialisePointSystem() {
        // Add each letter group and their corresponding point values to the points HashMap.
        points.put(new ArrayList<>(Arrays.asList("A", "E", "I", "O", "U", "L", "N", "R", "S", "T")), 1);
        points.put(new ArrayList<>(Arrays.asList("D", "G")), 2);
        points.put(new ArrayList<>(Arrays.asList("B", "C", "M", "P")), 3);
        points.put(new ArrayList<>(Arrays.asList("F", "H", "V", "W", "Y")), 4);
        points.put(new ArrayList<>(Arrays.asList("K")), 5);
        points.put(new ArrayList<>(Arrays.asList("J", "X")), 8);
        points.put(new ArrayList<>(Arrays.asList("Q", "Z")), 10);
    }

    WordScore(String word) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    int getScore() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}