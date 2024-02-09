package parser;

import org.apache.commons.cli.*;
import confighandlers.DefaultConfigBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class ParserArguments {
    private HashMap<Character, Object> arguments;

    public ParserArguments(String[] args) {
        DefaultConfigBuilder.CreateConfig.create();
        parse(args);
    }

    private Options setOptions(String[] args) {
        Options resultOptions = new Options();
        Option shortStatsOption = new Option("s", false, "short statistic");
        Option fullStatsOption = new Option("f", false, "full statistic");
        Option overwriteOption = new Option("a", false, "overwrite output files");
        Option prefixOption = new Option("p", true, "prefix for output files");
        Option outputOption = new Option("o", true, "output directory");
//        Option inputFileOption = new Option(null, true, "input file");

        shortStatsOption.setRequired(false);
        fullStatsOption.setRequired(false);
        overwriteOption.setRequired(false);
        prefixOption.setRequired(false);
        outputOption.setRequired(false);
//        inputFileOption.setRequired(false);

        resultOptions.addOption(shortStatsOption);
        resultOptions.addOption(fullStatsOption);
        resultOptions.addOption(overwriteOption);
        resultOptions.addOption(prefixOption);
        resultOptions.addOption(outputOption);
        resultOptions.addOption(shortStatsOption);
//        resultOptions.addOption(inputFileOption);
        return resultOptions;
    }

    private void parse(String[] args) {
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        Options options = setOptions(args);

        try {
            CommandLine cmdLine = parser.parse(options, args, false);

            System.out.println(Arrays.toString(cmdLine.getArgs()));

            for (Option opt : cmdLine.getOptions()) {
                System.out.println(opt.getOpt() + "   " + opt.getValue());
            }
//            System.out.println(Arrays.toString(cmdLine.getOptions()));
            System.out.println(checkCorrectFiles(cmdLine.getArgs()));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options, true);
//            formatter.printHelp();

        }
    }
    private ArrayList<String> checkCorrectFiles(String [] files) {
        ArrayList<String> correctFiles = new ArrayList<>();
        for (String it : files) {
            try {
                if (checkValidPathFile(it)) correctFiles.add(it);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return correctFiles;
    }
    private boolean checkValidPathFile(String path) throws FileNotFoundException {
        Path p = Paths.get(path);
        if (Files.exists(p)) return true;
        throw new FileNotFoundException("File " + path + " not found");
    }

}
