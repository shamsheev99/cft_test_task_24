package file.statistic;

import file.FileWriter;
import org.apache.log4j.Logger;
import statistic.types.IntegerType;

public class IntegerWriter extends FileWriter {
    private static final Logger log = Logger.getLogger(IntegerWriter.class);
    public IntegerWriter(String filePath, boolean overwrite, String statistic) {
        super(filePath + FileTypes.INTEGER.getType(), overwrite, statistic);
        if (!isNotNeedStat) {
            this.typeHandler = new IntegerType(!isShortStat);
        }
    }

    @Override
    public void writeToStatistic(String message) {
        typeHandler.pushStatistic(Integer.parseInt(message));
        log.debug("statistic pushed for message " + message );
    }

}
