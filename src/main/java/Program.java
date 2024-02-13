
import filehadlers.FilesHandler;
import parser.ParserArguments;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        ParserArguments parser = new ParserArguments(args);
        HashMap<String, String> parsedArgs = parser.parse();

        for (String key : parsedArgs.keySet()) {
            System.out.println(key + " parsed args " + parsedArgs.get(key));
        }
        //TODO изменить парсер чтобы не надо было заводить интовую переменную, а передавать сразу с мапы
        int flagStatistic = 0;
        if (parsedArgs.get("s").equals("true")) {
            flagStatistic = 1;
        } else if (parsedArgs.get("f").equals("true")) {
            flagStatistic = 2;
        }
        FilesHandler filesHandler = new FilesHandler(parsedArgs.get("files"), parsedArgs.get("o"),parsedArgs.get("p"), parsedArgs.get("a").equals("true"), flagStatistic);



    }
}
