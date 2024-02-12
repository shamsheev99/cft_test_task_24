package filehadlers;
import filehadlers.filewriters.FileWriterFloat;
import filehadlers.filewriters.FileWriterInteger;
import filehadlers.filewriters.FileWriterString;

import java.io.IOException;
import java.util.*;

public class FilesHandler {
    private List<String> path = new ArrayList<>();
    private final String outputPath;
    private final boolean overwrite;


    public FilesHandler(String filePaths, String outputPath, String prefix, boolean overwrite) {
        this.outputPath = outputPath + prefix;
        this.overwrite = overwrite;
        convertToList(filePaths);
        checkType();
    }

    private void convertToList(String filePaths) {
        path = Arrays.stream(filePaths.split(" ")).toList();
    }

    public void checkType() {
        FileWriterAbstract fwInteger;
        FileWriterAbstract fwFloat;
        FileWriterAbstract fwString;
        try {
            fwInteger = new FileWriterInteger(outputPath, overwrite);
            fwFloat = new FileWriterFloat(outputPath, overwrite);
            fwString = new FileWriterString(outputPath, overwrite);

            for (String it : path) {
                FileReaderAdapter fileReaderAdapter = new FileReaderAdapter(it);
                while (fileReaderAdapter.hasNext()) {
                    Scanner sc = new Scanner(fileReaderAdapter.readNext());
                    sc.useLocale(Locale.US);
                    if (sc.hasNextInt()) {
                        //TODO считать значение и вызвать статистику
                        pushToCorrectFIle(sc.next(), fwInteger);
                    } else if (sc.hasNextFloat()) {
                        //TODO считать значение и вызвать статистику
                        pushToCorrectFIle(sc.next(), fwFloat);
                    } else {
                        pushToCorrectFIle(sc.next(), fwString);
                        //TODO вызвать статистику
                    }
                }
            }
            fwInteger.close();
            fwString.close();
            fwFloat.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void pushToCorrectFIle(String value, FileWriterAbstract fw) {
        try {
            fw.writeToFile(value);
        }   catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //TODO add logs
            System.out.println("TUTA PUSHIT     " + value);
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
