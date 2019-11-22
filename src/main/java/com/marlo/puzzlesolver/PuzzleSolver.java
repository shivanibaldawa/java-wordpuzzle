package com.marlo.puzzlesolver;

import java.util.List;
import java.util.stream.Collectors;

/**
 * puzzlesolver class.
 *
 * @author Owner
 * @version $Id: $Id
 */
public class PuzzleSolver {

  /**
   * For every character in the dictionary word, removes that character from the input letter and
   * returns false if the character is not present thus not a valid word
   *
   * @param letters The inputLetters
   * @param word The dictionary word
   * @return Returns the ASCII value as an array for the input letters received
   */
  public static boolean isValid(final String letters, final String word) {
    List<Character> lettersList =
        letters.chars().mapToObj(letter -> (char) letter).collect(Collectors.toList());
    for (Character w : word.toCharArray()) {
      boolean changed = lettersList.remove(w);
      if (!changed) {
        return false;
      }
    }
    return true;
  }

  /*  public static boolean isAValidWord(List letters, String dWord)
  {
    List word = dWord.chars().mapToObj(c-> (char) c).collect(Collectors.toList());
    letters.forEach(i->word.remove(i));

    */
  /* for (Object letter : letters) {
    word.remove(letter);
  }*/
  /*
    return word.isEmpty();
  }*/
}
