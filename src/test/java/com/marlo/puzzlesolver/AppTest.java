package com.marlo.puzzlesolver;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.marlo.puzzlesolver.Validation.validation;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class AppTest {

  @Test
  public void validationtest() {
    String inputLetters = "vjhknhvhk";

    assertEquals(true, validation(inputLetters));
  }

  @Test
  public void validationtestfalse() {
    String inputLetters = "v2hknhvhk";

    assertEquals(false, validation(inputLetters));
  }

  @Test
  public void prepareDictionaryTest() {
    PuzzleSolver pz = new PuzzleSolver();
    String[] arr = {"Hi", "this", "is", "a", "test", "file"};
    Set<String> set = new HashSet<>(Arrays.asList(arr));

    assertEquals(set, pz.prepareDictionary());
  }

  @Test
  public void findwordstest() {
    PuzzleSolver pz = new PuzzleSolver();
    String test = "file";

    List<String> result = pz.findWords("life", "e", 4);
    assertTrue(result.contains(test));
  }
}
