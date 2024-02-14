package file.statistic;

import file.FileWriter;
import org.apache.log4j.Logger;
import statistic.types.StringType;

public class StringWriter extends FileWriter {
    private static final Logger log = Logger.getLogger(StringWriter.class);

    public StringWriter(String filePath, boolean overwrite, String statistic) {
        super(filePath + FileTypes.STRING.getType(), overwrite, statistic);
        if (!isNotNeedStat) {
            this.typeHandler = new StringType(!isShortStat);
        }
    }

    @Override
    public void writeToStatistic(String message) {
        typeHandler.pushStatistic(message);
        log.debug("statistic pushed for message " + message );
    }
}
