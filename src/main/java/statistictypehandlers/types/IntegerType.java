package statistictypehandlers.types;

import statistictypehandlers.AbstractStatisticHandler;

public class IntegerType extends AbstractStatisticHandler {
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
        if (data < (Integer)min) min = data;
        if (data > (Integer)max) max = data;
        average = (Integer)sum / count;

    }

    @Override
    public void printStatistic() {
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
