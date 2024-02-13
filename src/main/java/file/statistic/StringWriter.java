package file.statistic;

import file.FileWriter;
import statistic.types.FloatType;
import statistic.types.StringType;

import java.io.FileNotFoundException;

public class StringWriter extends FileWriter {
    public StringWriter(String filePath, boolean overwrite, String statistic) {
        super(filePath + FileTypes.STRING.getType(), overwrite, statistic);
        if (!isNotNeedStat) {
            this.typeHandler = new StringType(!isShortStat);
        }
    }

    @Override
    public void writeToStatistic(String message) {
        typeHandler.pushStatistic(message);
    }
}
