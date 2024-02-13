package filehadlers;

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
            fwInteger = new FileWriter(outputPath + FileTypes.INTEGER.getType(), overwrite, statistic);
            fwFloat = new FileWriter(outputPath + FileTypes.FLOAT.getType(), overwrite, statistic);
            fwString = new FileWriter(outputPath + FileTypes.STRING.getType(), overwrite, statistic);
            for (String it : path) {
                try {
                    Scanner sc = new Scanner(new File(it));
                    sc.useLocale(Locale.US);
                    while (sc.hasNextLine()) {
                        String value = sc.nextLine();
                        try {
                            fwInteger.writeToFile(value, Integer.parseInt(value));
                        } catch (Exception e) {
                            try {
                                fwFloat.writeToFile(value, Float.parseFloat(value));
                            } catch (Exception ex) {
                                fwString.writeToFile(value, value);
                            }
                        }
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

    enum FileTypes {
        INTEGER("integer.txt"), FLOAT("float.txt"), STRING("string.txt");
        private final String type;

        FileTypes(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
