package com.marlo.puzzlesolver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class puzzlesolver {

  Set<String> dictionary = new HashSet<>();

  // creates a hash set of all the words in dictionary
  public void prepareDictionary() {
    Scanner scan = null;
    try {
      scan =
          new Scanner(
              new FileReader(
                  "C:\\Users\\Owner\\IdeaProjects\\9letterPuzzleSolver\\Dictionary.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    while (scan.hasNext()) {
      dictionary.add(scan.next());
    }
  }

  public void findWords(String inputLetters, String mandatoryLetter, int minimumLength) {
    int[] allowed = new int[26];
    int validWordCount = 0;

    for (char c : inputLetters.toCharArray()) {
      int index = c - 'a';
      allowed[index]++;
    }

    // create list
    // Arrays.asList(inputLetters.toCharArray())

    // list.forEach( ...... )

    List<String> result = new ArrayList<>();

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
    Collections.sort(
        result,
        new Comparator<String>() {
          public int compare(String s1, String s2) {
            return s1.length() - s2.length();
          }
        });
    System.out.println(
        "Number of valid words from letters " + inputLetters + " : " + validWordCount);
    System.out.println(result);
  }
}
