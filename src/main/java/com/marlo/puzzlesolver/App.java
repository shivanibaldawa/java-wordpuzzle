package com.marlo.puzzlesolver;

public class App {

  static String inputLetters;
  static String mandatoryLetter;
  static int minimumLength;

  public static void main(String[] args) {

    inputLetters = args[0];
    mandatoryLetter = args[1];
    minimumLength = Integer.parseInt(args[2]);

    validation validate = new validation();
    boolean valid = validate.validation(inputLetters);

    if (valid) {
      puzzlesolver solver = new puzzlesolver();
      solver.prepareDictionary();
      solver.findWords(inputLetters, mandatoryLetter, minimumLength);
    } else {
      System.out.println("Enter 9 valid letters");
    }
  }
}
