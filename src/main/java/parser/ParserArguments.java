package parser;

import args.DefaultMap;
import org.apache.commons.cli.*;

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
        HashMap<String, String> parsedArgs = DefaultMap.getDefaultHashMap();
        try {
            CommandLine cmdLine = parser.parse(options, args, false);
            parsedArgs = OptionsHandler.convertOptionsToMap(cmdLine.getOptions());
            parsedArgs.put("files", fromListToStringCurrentFormat(cmdLine.getArgList()));
            return parsedArgs;
        } catch (ParseException e) {
            System.out.println("Error parsing arguments, using default settings" + e.getMessage());
            formatter.printHelp("file content filter utility", options, true);
            throw new IllegalArgumentException("Error parsing arguments");
        }
    }


    private static String fromListToStringCurrentFormat(List<String> list) {
        StringBuilder result = new StringBuilder();
        for (String item : list) {
            result.append(item);
            result.append(" ");
        }
        return result.toString();
    }


}
