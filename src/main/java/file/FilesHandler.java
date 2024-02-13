package file;

import file.statistic.FloatWriter;
import file.statistic.IntegerWriter;
import file.statistic.StringWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.util.*;

public class FilesHandler {
    private List<String> path = new ArrayList<>();
    private String outputPath;
    private boolean overwrite;
    private String statistic;


    public FilesHandler(HashMap<String, String> parameters) {
        setMapParameters(parameters);
    }

    private void setMapParameters(HashMap<String, String> parameters) {
        try {
            checkValidPathFile(parameters.get("o"));
            this.outputPath = parameters.get("o");
        } catch (NotDirectoryException e) {
            System.out.println(e.getMessage() + " Use default directory ./");
            this.outputPath = "./";
        }
        if (!outputPath.endsWith("/")) outputPath += "/";
        outputPath += parameters.get("p");
        this.overwrite = parameters.get("a").equals("true");
        this.statistic = parameters.get("s");
        convertToList(parameters.get("files"));

    }

    private static void checkValidPathFile(String currentPath) throws NotDirectoryException {
        Path p = Path.of(currentPath);
        if (Files.isWritable(p) && Files.isDirectory(p)) {
            System.out.println("zxczxc");
            return;
        }
        throw new NotDirectoryException("Directory " + p + " not found");
    }

    private void convertToList(String filePaths) {
        path = Arrays.stream(filePaths.split(" ")).toList();
    }

    public void checkType() {
        FileWriter fwInteger;
        FileWriter fwFloat;
        FileWriter fwString;
        try {
            fwInteger = new IntegerWriter(outputPath, overwrite, statistic);
            fwFloat = new FloatWriter(outputPath, overwrite, statistic);
            fwString = new StringWriter(outputPath, overwrite, statistic);
            for (String it : path) {
                try {
                    Scanner sc = new Scanner(new File(it));
                    sc.useLocale(Locale.US);
                    while (sc.hasNextLine()) {
//                     //   TODO сделать проверку регексом
                        String value = sc.nextLine();
                        if (value.matches("^[+-]?\\d+$")) fwInteger.writeToFile(value);
                        else if (!value.isEmpty() && value.matches("^\\d*[.]\\d+"))  fwFloat.writeToFile(value);
                        else  fwString.writeToFile(value);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
            fwInteger.close();
            fwFloat.close();
            fwString.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
