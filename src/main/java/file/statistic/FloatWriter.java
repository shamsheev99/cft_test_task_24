package file.statistic;

import file.FileWriter;
import org.apache.log4j.Logger;
import statistic.types.FloatType;

public class FloatWriter extends FileWriter {
    private static final Logger log = Logger.getLogger(FloatWriter.class);
    public FloatWriter(String filePath, boolean overwrite, String statistic) {
        super(filePath + FileTypes.FLOAT.getType(), overwrite, statistic);
        if (!isNotNeedStat) {
            this.typeHandler = new FloatType(!isShortStat);
        }
    }

    @Override
    public void writeToStatistic(String message) {
        typeHandler.pushStatistic(Float.parseFloat(message));
        log.debug("statistic pushed for message " + message );
    }

    /* if (!statistic.equals("0")) {
            if (filePath.endsWith("integer.txt")) typeHandler = new IntegerType(!statistic.equals("1"));
            else if (filePath.endsWith("float.txt")) typeHandler = new FloatType(!statistic.equals("1"));
            else if (filePath.endsWith("string.txt")) typeHandler = new StringType(!statistic.equals("1"));
            else System.out.println("error");
        }*/
}
