package statistictypehandlers.types;

import statistictypehandlers.AbstractProcessing;

public class IntegerType extends AbstractProcessing {
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
        count++;
        sum = (Integer) sum + data;
        if (data > (Integer)min) min = data;
        if (data > (Integer)max) max = data;
        average = (Integer)sum / count;
    }

    @Override
    public void printStatistic() {
        System.out.println("-----------------------------------------------");
        System.out.println("Количество элементов типа Integer: " + count);
        if (statisticFlag) {
            System.out.println("Минимальное значение: "+(Integer)min);
            System.out.println("Максимальное значение: "+(Integer)max);
            System.out.println("Сумма значений: "+(Integer)sum);
            System.out.println("Среднее значение: "+(Integer)average);
        }
    }
}
