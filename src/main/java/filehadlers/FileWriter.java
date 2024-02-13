package filehadlers;

import statistictypehandlers.AbstractStatisticHandler;
import statistictypehandlers.types.FloatType;
import statistictypehandlers.types.IntegerType;
import statistictypehandlers.types.StringType;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter {
    protected String filePath;
    protected FileOutputStream fos;
    protected int count = 0;
    protected boolean overwrite;
    AbstractStatisticHandler typeHandler;

    protected FileWriter(String filePath, boolean overwrite, String statistic) {
        this.filePath = filePath;
        this.overwrite = overwrite;
        if (!statistic.equals("0")) {
            if (filePath.endsWith("integer.txt")) typeHandler = new IntegerType(!statistic.equals("1"));
            else if (filePath.endsWith("float.txt")) typeHandler = new FloatType(!statistic.equals("1"));
            else if (filePath.endsWith("string.txt")) typeHandler = new StringType(!statistic.equals("1"));
            else System.out.println("error");
        }
    }

    public void writeToFile(String message, Object value) throws FileNotFoundException {
        if (count == 0) {
            fos = new FileOutputStream(filePath, overwrite);
        }
        System.out.println(filePath + "   TUTA PISHET MESASGE    /" + message);
        try {
            fos.write((message + System.lineSeparator()).getBytes());
            if (typeHandler != null) {
                typeHandler.pushStatistic(value);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        count++;
    }

    public void close() throws IOException {
        if (typeHandler != null) typeHandler.printStatistic();
        if (count != 0) fos.close();
    }
}
