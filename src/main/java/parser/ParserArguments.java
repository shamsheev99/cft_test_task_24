package parser;

import org.apache.commons.cli.*;
import confighandlers.DefaultConfigBuilder;

import java.util.HashMap;


public class ParserArguments {
    private HashMap<Character, Object> arguments;

    public ParserArguments(String[] args) {
        DefaultConfigBuilder.CreateConfig.create();
        parse(args);
    }

    private void parse(String[] args) {
        CommandLineParser parser = new DefaultParser();
    }

}
