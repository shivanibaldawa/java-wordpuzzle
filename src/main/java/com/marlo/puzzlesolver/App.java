package com.marlo.puzzlesolver;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

/**
 * App class.
 *
 * @author Owner
 * @version $Id: $Id
 */
@Slf4j
@Command(name = "Main", description = "Options", headerHeading = "Usage:%n%n")
public class App implements Runnable {

  @Option(
      names = {"-i", "--input"},
      required = true,
      description = "Valid 9 Input letters")
  String inputLetters;

  @Option(
      names = {"-m"},
      required = true,
      description = "The mandatory character")
  String mandatoryLetter;

  @Option(
      names = {"-l"},
      required = true,
      description = "Minimum length")
  int minimumLength;

  /* @Option(
      names = {"-h", "--help"},
      usageHelp = true,
      description = "display a help message")
  private boolean helpRequested = false;*/

  @Override
  public void run() {

    InputStream dictionary = App.class.getClassLoader().getResourceAsStream("english.dictionary");
    BufferedReader words = new BufferedReader(new InputStreamReader(dictionary, UTF_8));

    if (inputLetters.length() == 9 && inputLetters.matches("[a-zA-Z]+")) {

      words
          .lines()
          .filter(a -> a.contains(mandatoryLetter))
          .filter(a -> a.length() >= minimumLength)
          .filter(s -> PuzzleSolver.isValid(inputLetters, s))
          .forEach(System.out::println);
    } else {
      log.error("Enter 9 valid letters!!");
    }
    try {
      words.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Reads the dictionary and filters the stream of words as per the restrictions
   *
   * @param args an array of {@link String} objects.
   */
  public static void main(String[] args) {

    CommandLine.run(new App(), System.err, args);
  }
}
