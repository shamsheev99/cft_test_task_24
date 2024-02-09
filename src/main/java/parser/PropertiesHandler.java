package parser;

import confighandlers.DefaultConfigBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesHandler {
    public static void writePropertiesToFile(Properties properties, ArrayList<String> files) {
        properties.put("files", fromArrayListToStringCurrentFormat(files));
        try (FileOutputStream fos = new FileOutputStream(DefaultConfigBuilder.CreateConfig.path, false)) {
            properties.store(fos, "Parsed args");
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

    private static HashMap<String, String> convertFromPropertiesToHashMap(Properties properties) {
        return new (HashMap<String, String> properties;
    }
//    private static HashMap<String, String> checkCurrentProperties() {}
    private static Properties loadCurrentProperties() {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(DefaultConfigBuilder.CreateConfig.path);
            properties.load(fis);
            return properties;
        } catch(IOException e) {
            System.out.println(e.getMessage());
            DefaultConfigBuilder.CreateConfig.create();
            return loadCurrentProperties();
        }

    }
}
