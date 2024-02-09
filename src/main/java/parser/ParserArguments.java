package parser;

import org.apache.commons.cli.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class ParserArguments {

    public ParserArguments(String[] args) {
//        if (!Files.exists(Path.of(path))) DefaultConfigBuilder.CreateConfig.create();
        parse(args);
    }
    private void parse(String[] args) {
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        Options options = OptionsHandler.setOptions();

        try {
            CommandLine cmdLine = parser.parse(options, args, false);
            PropertiesHandler.writePropertiesToFile(OptionsHandler.convertOptionsToProperties(cmdLine.getOptions()), checkCorrectFiles(cmdLine.getArgList()));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("file content filter utility", options, true);
        }
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
