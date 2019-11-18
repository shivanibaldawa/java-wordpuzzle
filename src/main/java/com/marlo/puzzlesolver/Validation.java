package com.marlo.puzzlesolver;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * validation class.
 *
 * @author Owner
 * @version $Id: $Id
 */
public class Validation {

  /**
   * Checks for the length of the string and if the input string does not contain any other invalid
   * characters. Streams the dictionary as a bufferedReader and filters every word of the dictionary
   * by comparing it to the inputletter.
   *
   * @param inputLetters Input Letters
   * @param mandatoryLetter Mandatory Letter
   * @param minimumLength Minimum Length
   * @param words Dictionary Words
   * @return
   */
  public static List<String> findAndPrintValidWords(
      String inputLetters, String mandatoryLetter, int minimumLength, BufferedReader words) {
    int[] inputIndex = PuzzleSolver.input(inputLetters);
    Logger logger = LoggerFactory.getLogger("SampleLogger");
    List<String> result = new ArrayList<>();

    boolean valid = validate(inputLetters);

    if (valid) {
      result =
          words
              .lines()
              .filter(s -> PuzzleSolver.findWords(inputIndex, mandatoryLetter, minimumLength, s))
              .collect(Collectors.toList());

    } else {
      logger.error("Enter 9 valid letters!!");
    }
    return result;
  }
  /**
   * Checks if the input letter contains valid letters and the length of the input letters is 9
   *
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
