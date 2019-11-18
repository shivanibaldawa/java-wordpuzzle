package com.marlo.puzzlesolver;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
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
  public void inputTest() {
    int[] input = {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    String inputLetter = "abcd";
    Assert.assertArrayEquals(input, PuzzleSolver.input(inputLetter));
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

  @Test
  public void findAndPrintValidWordsTest() {
    List<String> result = new ArrayList<>();
    result.add("file");
    InputStream dictionary = AppTest.class.getClassLoader().getResourceAsStream("Dictionary.txt");
    BufferedReader br = new BufferedReader(new InputStreamReader(dictionary, UTF_8));
    String inputLetters = "afsbailse";
    String mandatoryLetter = "i";
    int minimumLength = 4;
    assertEquals(
        result,
        Validation.findAndPrintValidWords(inputLetters, mandatoryLetter, minimumLength, br));
  }
}
