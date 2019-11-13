package com.marlo.puzzlesolver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * puzzlesolver class.
 *
 * @author Owner
 * @version $Id: $Id
 */
public class PuzzleSolver {

  Set<String> dictionary = prepareDictionary();

  List<String> result = new ArrayList<>();
  int validWordCount;

  /** Create a hash set of all the words in dictionary. */
  public Set<String> prepareDictionary() {
    Path path = null;
    try {
      path = Paths.get(getClass().getClassLoader().getResource("Dictionary.txt").toURI());
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    Stream<String> lines = null;
    try {
      lines = Files.lines(path);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // String data = lines.collect(Collectors.joining("\n"));
    Set<String> dictionary = lines.collect(Collectors.toSet());
    return dictionary;
    //  lines.close();
  }

  /**
   * findWords.
   *
   * @param inputLetters a {@link java.lang.String} object.
   * @param mandatoryLetter a {@link java.lang.String} object.
   * @param minimumLength a int.
   */

  /**
   * Maps all the characters in the input letters to an array of integers of 26 letters Checks the
   * words int the dictionary with respect to the restrictions of the mandatory character and
   * minimum length Maps the valid words to another array count for every word in the dictionary
   * Compares the input letters array to the count array and returns the result list of all valid
   * words
   */
  public List<String> findWords(String inputLetters, String mandatoryLetter, int minimumLength) {
    int[] allowed = new int[26];

    inputLetters
        .chars()
        .mapToObj(c -> (char) c)
        .mapToInt(
            (Character c) -> {
              return c - 'a';
            })
        .forEach(
            index -> {
              allowed[index]++;
            });

    for (String dword : dictionary) {
      // Constraints
      if (dword.length() < minimumLength || !dword.contains(mandatoryLetter)) {
        continue;
      }

      int[] count = new int[26];
      boolean valid = true;

      for (char c : dword.toCharArray()) {
        int index = c - 'a';
        count[index]++;
        if (count[index] > allowed[index]) {
          valid = false;
          break;
        }
      }
      if (valid) {
        result.add(dword);
        validWordCount++;
      }
    }

    Collections.sort(result, Comparator.<String>comparingInt(String::length));

    return result;
  }

  public void printResults(List<String> r) {
    System.out.println(
        "Number of valid words from letters " + App.inputLetters + ": " + validWordCount);
    r.forEach(
        a -> {
          System.out.println(a);
        });
  }
}
