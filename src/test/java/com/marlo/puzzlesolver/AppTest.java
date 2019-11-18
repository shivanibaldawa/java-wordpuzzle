package com.marlo.puzzlesolver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {

  @Test
  public void validationTest() {
    String inputLetters = "vjhknhvhk";
    // App.main();
    assertTrue("Validation test successful", Validation.validate(inputLetters));
  }

  @Test
  public void validationTestFalse() {
    String inputLetters = "v2hknhvhk";

    assertFalse("Validation test successful", Validation.validate(inputLetters));
  }

  @Test
  public void findWordsTest() {
    int[] input = PuzzleSolver.input("elifasrty");
    String mandatoryLetter = "i";
    int minimumLength = 4;
    String dWord = "file";
    assertTrue(
        "The input letters contains the word file",
        PuzzleSolver.findWords(input, mandatoryLetter, minimumLength, dWord));
  }
}
