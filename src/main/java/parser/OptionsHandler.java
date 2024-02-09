package parser;

import confighandlers.DefaultConfigBuilder;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Properties;

public class OptionsHandler {
    public static Options setOptions() {
        Options resultOptions = new Options();
        Option shortStatsOption = new Option("s", false, "short statistic");
        Option fullStatsOption = new Option("f", false, "full statistic");
        Option overwriteOption = new Option("a", false, "overwrite output files");
        Option prefixOption = new Option("p", true, "prefix for output files");
        Option outputOption = new Option("o", true, "output directory");

        shortStatsOption.setRequired(false);
        shortStatsOption.setType(Boolean.class);
        fullStatsOption.setRequired(false);
        fullStatsOption.setType(Boolean.class);
        overwriteOption.setRequired(false);
        overwriteOption.setType(Boolean.class);
        prefixOption.setRequired(false);
        outputOption.setRequired(false);

        resultOptions.addOption(shortStatsOption);
        resultOptions.addOption(fullStatsOption);
        resultOptions.addOption(overwriteOption);
        resultOptions.addOption(prefixOption);
        resultOptions.addOption(outputOption);
        resultOptions.addOption(shortStatsOption);

        return resultOptions;
    }

    public static HashMap<String, String> convertOptionsToMap(Option[] options) {
        HashMap<String, String> resultMapForConvert = DefaultConfigBuilder.CreateConfig.getDefaultHashMap();
        for (Option option : options) {
            if (option.getOpt().equals("o")) {
                if (checkCorrectDirectory(option.getValue())) {
                    resultMapForConvert.put(option.getOpt(), option.getValue());
                } else {
                    System.out.println(option.getValue() + " is not a directory");
                }
            }else if (option.getValue() == null) {
                resultMapForConvert.put(option.getOpt(), "true");
            } else {
                resultMapForConvert.put(option.getOpt(), option.getValue());
            }
        }

        return resultMapForConvert;
    }

    private static boolean checkCorrectDirectory(String directory) {
        return (Files.isDirectory(Path.of(directory)));
    }

}
