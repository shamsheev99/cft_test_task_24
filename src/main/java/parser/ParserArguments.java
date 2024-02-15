package parser;

import args.DefaultMap;
import org.apache.commons.cli.*;
import org.apache.log4j.Logger;

import java.util.*;


public class ParserArguments {
    private final String[] args;
    private static final Logger log = Logger.getLogger(ParserArguments.class);
    public ParserArguments(String[] args) {
        this.args = args;
    }

    public HashMap<String, String> parse() throws Exception {
        HelpFormatter formatter = new HelpFormatter();
        Options options = OptionsHandler.setOptions();

        if (args.length == 0) {
            formatter.printHelp("file content filter utility", options, true);
            throw new IllegalArgumentException("Please use args");
        }
        CommandLineParser parser = new DefaultParser();
        HashMap<String, String> parsedArgs;
        try {
            CommandLine cmdLine = parser.parse(options, args, false);
            if (cmdLine.getArgList().isEmpty()) throw new ParseException("Укажите входные файлы");
            parsedArgs = OptionsHandler.convertOptionsToMap(cmdLine.getOptions());
            parsedArgs.put("files", fromListToStringCurrentFormat(cmdLine.getArgList()));
            return parsedArgs;
        } catch (ParseException e) {
            log.error("Error parsing arguments, using default settings " + e.getMessage());
            formatter.printHelp("file content filter utility", options, true);
            throw new Exception(e.getMessage());
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
