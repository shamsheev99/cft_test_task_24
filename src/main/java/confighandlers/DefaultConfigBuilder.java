package confighandlers;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Properties;

public class DefaultConfigBuilder {
    public static class CreateConfig {
        public static void create() {
            File file = new File("./src/main/resources/configArgs.properties");
            HashMap<Object, Object> map = new HashMap<>();
            map.put("a", "false");
            map.put("o", "./");
            map.put("p", "");
            map.put("s", "false");
            map.put("f", "false");
            map.put("files","");
            Properties properties = new Properties();
            properties.putAll(map);
            try {
                properties.store(Files.newOutputStream(file.toPath()), "File contain args for program");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}