package com.marlo.puzzlesolver;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    Logger logger = LoggerFactory.getLogger(App.class);

    final Options options = new Options();
    final String inputLetters;
    final String mandatoryLetter;
    final int minimumLength;
    List<String> result = new ArrayList<>();

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
      }

      inputLetters = cmd.getOptionValue("i");
      mandatoryLetter = cmd.getOptionValue("m");
      minimumLength = Integer.parseInt(cmd.getOptionValue("l"));

      InputStream dictionary = App.class.getClassLoader().getResourceAsStream("english.dictionary");
      BufferedReader words = new BufferedReader(new InputStreamReader(dictionary, UTF_8));

      result=Validation.findAndPrintValidWords(inputLetters, mandatoryLetter, minimumLength, words);
      result.stream().forEach( s-> logger.info(s + "\n"));

    } catch (ParseException e) {
      logger.error("An exception occurred");
    }
  }
}
