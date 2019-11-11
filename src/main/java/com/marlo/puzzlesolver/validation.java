package com.marlo.puzzlesolver;

public class validation {

  // checks for the length of the string and if the input string does not contain any other invalid
  // characters
  public static boolean validation(String inputLetters) {

    if ((inputLetters.length() != 9) || !inputLetters.matches("[a-zA-Z]+")) {
      return false;
    } else {
      return true;
    }
  }
}
