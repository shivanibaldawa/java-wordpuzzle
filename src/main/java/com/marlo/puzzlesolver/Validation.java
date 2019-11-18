package com.marlo.puzzlesolver;

import java.io.BufferedReader;

/**
 * validation class.
 *
 * @author Owner
 * @version $Id: $Id
 */
public class Validation {

  /**
   * @param inputLetters Input Letters
   * @param mandatoryLetter Mandatory Letter
   * @param minimumLength Minimum Length
   * @param words Dictionary Words
   *
   * Checks for the length of the string and if the input string does not contain any other invalid
   * characters. Streams the dictionary as a bufferedReader and filters every word of the dictionary
   * by comparing it to the inputletter.
   */
  public static void findValidWords(
      String inputLetters, String mandatoryLetter, int minimumLength, BufferedReader words) {
    int[] inputIndex = PuzzleSolver.input(inputLetters);

    boolean valid = validate(inputLetters);

    if (valid) {
      System.out.println("The valid words from " + inputLetters + ":");
      words
          .lines()
          .filter(s -> PuzzleSolver.findWords(inputIndex, mandatoryLetter, minimumLength, s))
          .forEach(System.out::println);
    } else {
      System.out.println("Enter 9 valid letters");
    }
  }
  /**
   * @param inputLetters a {@link java.lang.String} object.
   * @return a boolean.
   */
  public static boolean validate(final String inputLetters) {

    if (inputLetters.length() != 9 || !inputLetters.matches("[a-zA-Z]+")) {
      return false;
    } else {
      return true;
    }
  }
}
