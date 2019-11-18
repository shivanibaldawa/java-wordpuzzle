package com.marlo.puzzlesolver;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.commons.cli.*;

/**
 * App class.
 *
 * @author Owner
 * @version $Id: $Id
 */
public class App {

  /**
   * Command line argument parsing and reads the dictionary from the resources.
   *
   * @param args an array of {@link java.lang.String} objects.
   */
  public static void main(String[] args) {

    final Options options = new Options();
    final String inputLetters;
    final String mandatoryLetter;
    final int minimumLength;

    options.addRequiredOption("i", "input", true, "Valid letters");
    options.addRequiredOption("m", "mandatory", true, "Mandatory letter");
    options.addRequiredOption("l", "minimum", true, "Minimum word length");
    options.addOption("h", "help", false, "Help");

    CommandLineParser parser = new DefaultParser();

    try {
      CommandLine cmd = parser.parse(options, args);

      if (cmd.getOptions().length == 0 || cmd.hasOption("h")) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("-h", options);
        // System.exit(0);
      }

      inputLetters = cmd.getOptionValue("i");
      mandatoryLetter = cmd.getOptionValue("m");
      minimumLength = Integer.parseInt(cmd.getOptionValue("l"));

      InputStream dictionary = App.class.getClassLoader().getResourceAsStream("english.dictionary");
      BufferedReader words = new BufferedReader(new InputStreamReader(dictionary, UTF_8));

      Validation.findValidWords(inputLetters, mandatoryLetter, minimumLength, words);

    } catch (ParseException e) {
      System.err.println(e);
    }
  }
}
