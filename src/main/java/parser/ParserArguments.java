package parser;

import confighandlers.DefaultConfigBuilder;

import java.util.HashMap;


public class ParserArguments {
    private HashMap<Character, Object> arguments;
    public ParserArguments(String[] args) {
        DefaultConfigBuilder.CreateConfig.create();
    }
}
