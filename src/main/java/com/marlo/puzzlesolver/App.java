package com.marlo.puzzlesolver;

import java.util.List;

/**
 * App class.
 *
 * @author Owner
 * @version $Id: $Id
 */
public class App {

  static String inputLetters;
  static String mandatoryLetter;
  static int minimumLength;

  /**
   * main.
   *
   * @param args an array of {@link java.lang.String} objects.
   */
  public static void main(String[] args) {

    inputLetters = args[0];
    mandatoryLetter = args[1];
    minimumLength = Integer.parseInt(args[2]);

    boolean valid = Validation.validation(inputLetters);

    if (valid) {
      PuzzleSolver solver = new PuzzleSolver();
      solver.prepareDictionary();
      List<String> result = solver.findWords(inputLetters, mandatoryLetter, minimumLength);
      solver.printResults(result);

    } else {
      System.out.println("Enter 9 valid letters");
    }
  }
}
