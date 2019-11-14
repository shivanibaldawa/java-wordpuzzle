package com.marlo.puzzlesolver;

import org.apache.commons.cli.*;

import java.util.ArrayList;
import java.util.List;

/**
 * App class.
 *
 * @author Owner
 * @version $Id: $Id
 */
public class App {

  static String inputLetters;
  static String mandatoryLetter;
  static int minimumLength;
  static Options options = new Options();

  /**
   * main.
   *
   * @param args an array of {@link java.lang.String} objects.
   */
  public static void main(String[] args) {

    List<String> result = new ArrayList<>();

    options.addRequiredOption("i", "Input letters", true, "Enter input letters");
    options.addRequiredOption("m", "Mandatory letters", true, "Enter mandatory letter");
    options.addRequiredOption("l", "Minimum length", true, "Enter minimum length");
    options.addOption("h", false, "Help");

    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = null;
    try {
      cmd = parser.parse(options, args);

      if (cmd.getOptions().length == 0 || cmd.hasOption("h")) {
        help();
      }
      if (cmd.hasOption("i") && cmd.hasOption("m") && cmd.hasOption("l")) {
        // List<String> result = new ArrayList<>();
        inputLetters = cmd.getOptionValue("i");
        mandatoryLetter = cmd.getOptionValue("m");
        minimumLength = Integer.parseInt(cmd.getOptionValue("l"));


        /*
            inputLetters = args[0];
            mandatoryLetter = args[1];
            minimumLength = Integer.parseInt(args[2]);
        */

        boolean valid = Validation.validation(inputLetters);

        if (valid) {
          PuzzleSolver solver = new PuzzleSolver();
          solver.prepareDictionary();
          result = solver.findWords(inputLetters, mandatoryLetter, minimumLength);
          solver.printResults(result);
        } else {
          System.out.println("Enter 9 valid letters");
        }
      }
    } catch (ParseException e) {
      System.err.println("Unexpected exception: " + e.getMessage());
    }
  }

  public static void help() {
    HelpFormatter formatter = new HelpFormatter();
    formatter.printHelp("-h", options);
    System.exit(0);
  }
}
