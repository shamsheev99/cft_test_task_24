package parser;

import confighandlers.DefaultConfigBuilder;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

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

    public static Properties convertOptionsToProperties(Option[] options) {
        HashMap<String, String> templateMapForConvert = DefaultConfigBuilder.CreateConfig.getDefaultHashMap();
        Properties properties = new Properties();
        for (Option option : options) {
            if (option.getValue() == null) {
                templateMapForConvert.put(option.getOpt(), "true");
            } else {
                templateMapForConvert.put(option.getOpt(), option.getValue());
            }
        }
        properties.putAll(templateMapForConvert);
        return properties;
    }
}
