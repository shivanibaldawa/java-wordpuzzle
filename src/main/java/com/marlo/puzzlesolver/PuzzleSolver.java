package com.marlo.puzzlesolver;

import java.util.ArrayList;
import java.util.List;

/**
 * puzzlesolver class.
 *
 * @author Owner
 * @version $Id: $Id
 */
public class PuzzleSolver {

  /**
   * Maps all the characters in the input letters to an array of integers of 26 letters.
   *
   * @param inputLetters The inputLetters
   * @return Returns the ASCII value as an array for the input letters received
   */
  public static int[] input(final String inputLetters) {

    int[] allowed = new int[26];

    inputLetters
        .chars()
        .mapToObj(c -> (char) c)
        .mapToInt(
            (Character c) -> {
              return c - 'a';
            })
        .forEach(
            index -> {
              allowed[index]++;
            });

    return allowed;
  }
  /**
   * Checks the word in the dictionary with respect to the restrictions of the mandatory character
   * and minimum length. Maps the word in the dictionary to an array count in the dictionary.
   * Compares the input letters array to the count array and returns true if the word is valid.
   *
   * @param inputIndex {@link java.lang.String} object.
   * @param mandatoryLetter a {@link java.lang.String} object.
   * @param minimumLength a int.
   * @param dword Dictionary word
   * @return Returns if the dictionary word is valid
   */
  public static boolean findWords(
      final int[] inputIndex, final String mandatoryLetter, final int minimumLength, String dword) {

    // Constraints
    if (dword.length() < minimumLength || !dword.contains(mandatoryLetter)) return false;

    int[] count = new int[26];
    boolean valid = true;

    for (char c : dword.toCharArray()) {
      int index = c - 'a';
      count[index]++;
      if (count[index] > inputIndex[index]) {
        valid = false;
        break;
      }
    }
    return valid;
  }
}
