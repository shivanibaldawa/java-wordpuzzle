package com.marlo.puzzlesolver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

  @Test
  public void inputTest() {
    int[] input = {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    String inputLetter = "abcd";
    Assert.assertArrayEquals(input, PuzzleSolver.input(inputLetter));
  }

  @Test
  public void findWordsTest() {
    int[] input = PuzzleSolver.input("elifasrty");
    String dWord = "file";
    assertTrue("The input letters contains the word file", PuzzleSolver.findWords(input, dWord));
  }

  @Test
  public void rejectInvalidWordTest() {
    int[] input = PuzzleSolver.input("elifasrty");
    String dWord = "filee";
    assertFalse(
        "The input letters does not contain the word filee", PuzzleSolver.findWords(input, dWord));
  }
}
