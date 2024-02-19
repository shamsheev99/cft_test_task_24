package statistic.types;

import org.apache.log4j.Logger;
import statistic.AbstractStatisticHandler;

public class StringType extends AbstractStatisticHandler {
    private static final Logger log = Logger.getLogger(StringType.class);
    public StringType(boolean statisticType) {
        super(statisticType);
        min = 0;
        max = 0;
    }

    @Override
    public void pushStatistic(Object value) {
        String data = (String)value;
        if (count == 0) {
            min = Integer.MAX_VALUE;
        }
        count++;
        min = Math.min(data.length(), (Integer)min);
        max = Math.max(data.length(), (Integer)max);
    }

    @Override
    public void printStatistic() {
        if (count == 0) return;
        log.info("printStatistics: "+ count + " elements");
        System.out.println("-----------------------------------------------");
        System.out.println("Количество элементов типа String: " + count);
        if (statisticFlag) {
            System.out.println("Минимальная длина строки: "+min);
            System.out.println("Максимальная длина строки: "+max);
        }
    }
}
