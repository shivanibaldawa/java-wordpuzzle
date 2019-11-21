package com.marlo.puzzlesolver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {

  @Test
  public void isValidWordTest() {
    /*List<Character> input = new ArrayList<>();
        input.add('o');
        input.add('b');
        input.add('d');
        input.add('b');
        input.add('k');
        input.add('h');
        input.add('o');
        input.add('s');
        input.add('r');
    */
    String input = "ajswbookf";
    String dWord = "book";
    assertTrue("The dWord is a valid word", PuzzleSolver.isValid(input, dWord));
  }

  @Test
  public void rejectInvalidWordTest() {
    String input = "elifasrty";
    String dWord = "filee";
    assertFalse(
        "The input letters does not contain the word filee", PuzzleSolver.isValid(input, dWord));
  }
}
