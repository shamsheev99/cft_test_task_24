package filehadlers;
import filehadlers.filewriters.FileWriterFloat;
import filehadlers.filewriters.FileWriterInteger;
import filehadlers.filewriters.FileWriterString;
import statistictypehandlers.AbstractProcessing;
import statistictypehandlers.types.FloatType;
import statistictypehandlers.types.IntegerType;
import statistictypehandlers.types.StringType;

import java.io.IOException;
import java.util.*;

public class FilesHandler {
    private List<String> path = new ArrayList<>();
    private final String outputPath;
    private final boolean overwrite;
    private final int statistic;


    public FilesHandler(String filePaths, String outputPath, String prefix, boolean overwrite, int statistic) {
        this.outputPath = outputPath + prefix;
        this.overwrite = overwrite;
        this.statistic = statistic;
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
        AbstractProcessing typeHandlerInt = null;
        AbstractProcessing typeHandlerFlt = null;
        AbstractProcessing typeHandlerStr = null;
        try {
            fwInteger = new FileWriterInteger(outputPath, overwrite);
            fwFloat = new FileWriterFloat(outputPath, overwrite);
            fwString = new FileWriterString(outputPath, overwrite);
            if (statistic != 0) {
                //TODO подумать как это оптимизировать, т.к. ухудшает читаемость
                boolean flag = statistic != 1;
                typeHandlerInt = new IntegerType(flag);
                typeHandlerFlt = new FloatType(flag);
                typeHandlerStr = new StringType(flag);
            }
            for (String it : path) {
                FileReaderAdapter fileReaderAdapter = new FileReaderAdapter(it);
                while (fileReaderAdapter.hasNext()) {
                    Scanner sc = new Scanner(fileReaderAdapter.readNext());
                    sc.useLocale(Locale.US);
                    if (sc.hasNextInt()) {
                        String value = sc.next();
                        if (statistic != 0) {
                            typeHandlerInt.pushStatistic(Integer.parseInt(value));
                        }
                        pushToCorrectFIle(value, fwInteger);
                    } else if (sc.hasNextFloat()) {
                        String value = sc.next();
                        if (statistic != 0) {
                            typeHandlerFlt.pushStatistic(Float.parseFloat(value));
                        }
                        pushToCorrectFIle(value, fwFloat);
                    } else {
                        String value = sc.next();
                        if (statistic != 0) {
                            typeHandlerStr.pushStatistic(value);
                        }
                        pushToCorrectFIle(value, fwString);
                    }
                }
                if (statistic != 0) {
                    typeHandlerInt.printStatistic();
                    typeHandlerFlt.printStatistic();
                    typeHandlerStr.printStatistic();
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
