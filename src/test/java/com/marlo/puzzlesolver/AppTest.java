package com.marlo.puzzlesolver;

import static com.marlo.puzzlesolver.Validation.validation;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import junit.framework.TestCase;
import org.junit.Test;

public class AppTest {

  @Test
  public void validationtest() {
    String inputLetters = "vjhknhvhk";
    // App.main();
    TestCase.assertTrue("Validation test successful", validation(inputLetters));
  }

  @Test
  public void validationtestfalse() {
    String inputLetters = "v2hknhvhk";

    assertFalse("Validation test successful", validation(inputLetters));
  }

  @Test
  public void prepareDictionaryTest() {
    PuzzleSolver pz = new PuzzleSolver();
    String[] arr = {"Hi", "this", "is", "a", "test", "file"};
    Set<String> set = new HashSet<>(Arrays.asList(arr));

    assertEquals("Prepare dictionary successful", set, pz.prepareDictionary());
  }

  @Test
  public void findWordsTest() {
    PuzzleSolver pz = new PuzzleSolver();
    String test = "file";

    List<String> result = pz.findWords("life", "e", 4);
    assertTrue("Test findwords successful", result.contains(test));
  }
}
