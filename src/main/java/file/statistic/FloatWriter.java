package file.statistic;

import file.FileWriter;
import statistic.types.FloatType;

import java.io.FileNotFoundException;

public class FloatWriter extends FileWriter {
    public FloatWriter(String filePath, boolean overwrite, String statistic) {
        super(filePath + FileTypes.FLOAT.getType(), overwrite, statistic);
        if (!isNotNeedStat) {
            this.typeHandler = new FloatType(!isShortStat);
        }
    }

    @Override
    public void writeToStatistic(String message) throws FileNotFoundException {
        typeHandler.pushStatistic(Float.parseFloat(message));
    }

    /* if (!statistic.equals("0")) {
            if (filePath.endsWith("integer.txt")) typeHandler = new IntegerType(!statistic.equals("1"));
            else if (filePath.endsWith("float.txt")) typeHandler = new FloatType(!statistic.equals("1"));
            else if (filePath.endsWith("string.txt")) typeHandler = new StringType(!statistic.equals("1"));
            else System.out.println("error");
        }*/
}
