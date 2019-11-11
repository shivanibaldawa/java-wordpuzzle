package com.marlo.puzzlesolver;

import static com.marlo.puzzlesolver.validation.validation;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {
  /** Rigorous Test :-) */
  @Test
  public void shouldAnswerWithTrue() {
    assertTrue(true);
  }

  @Test
  public void validationtest() {
    String inputLetters = "vjhknhvhk";

    assertEquals(true, validation(inputLetters));
  }
}
