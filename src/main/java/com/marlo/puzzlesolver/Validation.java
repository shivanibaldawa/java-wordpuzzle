package com.marlo.puzzlesolver;

/**
 * validation class.
 *
 * @author Owner
 * @version $Id: $Id
 */
public class Validation {

  /**
   * Checks for the length of the string and if the input string does not contain any other invalid
   * characters.
   *
   * @param inputLetters a {@link java.lang.String} object.
   * @return a boolean.
   */
  public static boolean validation(String inputLetters) {

    if (inputLetters.length() != 9 || !inputLetters.matches("[a-zA-Z]+")) {
      return false;
    } else {
      return true;
    }
  }
}
