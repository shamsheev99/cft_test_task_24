package parser;

import confighandlers.DefaultConfigBuilder;
import org.apache.commons.cli.*;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class ParserArguments {
    private final String[] args;

    public ParserArguments(String[] args) {
        this.args = args;
    }

    public HashMap<String, String> parse() {
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        Options options = OptionsHandler.setOptions();
        HashMap<String, String> parsedArgs = DefaultConfigBuilder.CreateConfig.getDefaultHashMap();
        try {
            CommandLine cmdLine = parser.parse(options, args, false);
            parsedArgs = OptionsHandler.convertOptionsToMap(cmdLine.getOptions());
            parsedArgs.put("files", fromArrayListToStringCurrentFormat(checkCorrectFiles(cmdLine.getArgList())));
            return parsedArgs;
        } catch (ParseException e) {
            System.out.println("Error parsing arguments, using default settings" + e.getMessage());
            formatter.printHelp("file content filter utility", options, true);
            throw new IllegalArgumentException("Error parsing arguments");
        }
    }

    private static String fromArrayListToStringCurrentFormat(ArrayList<String> list) {
        StringBuilder result = new StringBuilder();
        for (String item : list) {
            result.append(item);
            result.append(" ");
        }
        return result.toString();
    }


    private static ArrayList<String> checkCorrectFiles(List<String> files) {
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

    private static boolean checkValidPathFile(String currentPath) throws FileNotFoundException {
        Path p = Path.of(currentPath);
        System.out.println(p + " -------------");
        if (Files.exists(p) && Files.isWritable(p) && !Files.isDirectory(p)) return true;
        throw new FileNotFoundException("File " + p + " not found");
    }

}
