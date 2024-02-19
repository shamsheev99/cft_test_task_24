package statistic.types;

import org.apache.log4j.Logger;
import statistic.AbstractStatisticHandler;

public class IntegerType extends AbstractStatisticHandler {
    private static final Logger log = Logger.getLogger(IntegerType.class);
    public IntegerType(boolean statisticFlag) {
        super(statisticFlag);
        min = 0;
        max = 0;
        average = 0;
        sum = 0;
    }

    @Override
    public void pushStatistic(Object value) {
        Integer data = (Integer)value;
        if (count == 0) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }
        count++;
        sum = (Integer) sum + data;
        min = Math.min(data, (Integer)min);
        max = Math.max(data, (Integer)max);
        average = (Integer)sum / count;

    }

    @Override
    public void printStatistic() {
        if (count == 0) return;
        log.info("printStatistics "+ count + " elements");
        System.out.println("-----------------------------------------------");
        System.out.println("Количество элементов типа Integer: " + count);
        if (statisticFlag) {
            System.out.println("Минимальное значение: "+min);
            System.out.println("Максимальное значение: "+max);
            System.out.println("Сумма значений: "+sum);
            System.out.println("Среднее значение: "+average);
        }
    }
}
