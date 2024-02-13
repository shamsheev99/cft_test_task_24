package file.statistic;

import file.FileWriter;
import statistic.types.FloatType;
import statistic.types.IntegerType;

import java.io.FileNotFoundException;

public class IntegerWriter extends FileWriter {
    public IntegerWriter(String filePath, boolean overwrite, String statistic) {
        super(filePath + FileTypes.INTEGER.getType(), overwrite, statistic);
        if (!isNotNeedStat) {
            this.typeHandler = new IntegerType(!isShortStat);
        }
    }

    @Override
    public void writeToStatistic(String message) {
        typeHandler.pushStatistic(Integer.parseInt(message));
    }

}
