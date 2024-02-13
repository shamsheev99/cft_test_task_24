
import file.FilesHandler;
import parser.ParserArguments;

import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        ParserArguments parser = new ParserArguments(args);
        HashMap<String, String> parsedArgs = parser.parse();

        for (String key : parsedArgs.keySet()) {
            System.out.println(key + " parsed args " + parsedArgs.get(key));
        }
        FilesHandler fileHandler = new FilesHandler(parsedArgs);
        fileHandler.checkType();



    }
}

