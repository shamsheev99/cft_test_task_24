
import file.FilesHandler;
import org.apache.log4j.Logger;
import parser.ParserArguments;

import java.util.HashMap;

public class Program {
    private static final Logger log = Logger.getLogger(Program.class);
    public static void main(String[] args) {
        ParserArguments parser = new ParserArguments(args);
        HashMap<String, String> parsedArgs = parser.parse();

        for (String key : parsedArgs.keySet()) {
            log.debug(key + " parsed args " + parsedArgs.get(key));
//            System.out.println(key + " parsed args " + parsedArgs.get(key));
        }
        FilesHandler fileHandler = new FilesHandler(parsedArgs);
        fileHandler.checkType();



    }
}

