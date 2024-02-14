package statistic.types;

import org.apache.log4j.Logger;
import statistic.AbstractStatisticHandler;

public class FloatType extends AbstractStatisticHandler {
    private static final Logger log = Logger.getLogger(FloatType.class);
    public FloatType(boolean statisticFlag) {
        super(statisticFlag);
        min = 0f;
        max = 0f;
        average = 0f;
        sum = 0f;
    }

    @Override
    public void pushStatistic(Object value) {
        Float data = (Float) value;
        if (count == 0) {
            min = Float.MAX_VALUE;
            max = Float.MIN_VALUE;
        }
        count++;
        sum = (Float) sum + data;
        if (data < (Float) min) min = data;
        if (data > (Float) max) max = data;
        average = (Float) sum / count;
    }

    @Override
    public void printStatistic() {
        log.info("printStatistics "+ count + " elements");
        System.out.println("-----------------------------------------------");
        System.out.println("Количество элементов типа Float: " + count);
        if (statisticFlag) {
            System.out.println("Минимальное значение: " + min);
            System.out.println("Максимальное значение: " + max);
            System.out.println("Сумма значений: " + sum);
            System.out.println("Среднее значение: " + average);
        }
    }
}