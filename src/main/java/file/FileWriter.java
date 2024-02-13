package file;

import statistic.AbstractStatisticHandler;
import statistic.types.FloatType;
import statistic.types.IntegerType;
import statistic.types.StringType;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class FileWriter {
    protected String filePath;
    protected FileOutputStream fos;
    protected int count = 0;
    protected boolean overwrite;
    protected AbstractStatisticHandler typeHandler;
    protected boolean isNotNeedStat;
    protected boolean isShortStat;

    protected FileWriter(String filePath, boolean overwrite, String statistic) {
        this.filePath = filePath;
        this.overwrite = overwrite;
        isNotNeedStat = statistic.equals(Statistic.NOTSTAT.getStat());
        isShortStat = statistic.equals(Statistic.SHORTSTAT.getStat());
    }

    public abstract void writeToStatistic(String message) throws FileNotFoundException;


    public void writeToFile(String message) throws FileNotFoundException {
        if (count == 0) {
            fos = new FileOutputStream(filePath, overwrite);
        }
        System.out.println(filePath + "   TUTA PISHET MESASGE    /" + message);
        try {
            fos.write((message + System.lineSeparator()).getBytes());
            if (typeHandler != null) {
                writeToStatistic(message);
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

    protected enum FileTypes {
        INTEGER("integer.txt"), FLOAT("float.txt"), STRING("string.txt");
        private final String type;

        FileTypes(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
    protected enum Statistic{
        NOTSTAT("not"), SHORTSTAT("short"), FULLSTAT("full");
        private final String statistic;

        Statistic(String statistic) {
            this.statistic = statistic;
        }

        public String getStat() {
            return statistic;
        }
    };

}
