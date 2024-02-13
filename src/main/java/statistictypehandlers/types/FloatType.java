package statistictypehandlers.types;

import statistictypehandlers.AbstractProcessing;

public class FloatType extends AbstractProcessing {
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
        count++;
        sum = (Float) sum + data;
        if (data > (Float) min) min = data;
        if (data > (Float) max) max = data;
        average = (Float) sum / count;
    }

    @Override
    public void printStatistic() {
        System.out.println("-----------------------------------------------");
        System.out.println("Количество элементов типа Float: " + count);
        if (statisticFlag) {
            System.out.println("Минимальное значение: "+(Float)min);
            System.out.println("Максимальное значение: "+(Float)max);
            System.out.println("Сумма значений: "+(Float)sum);
            System.out.println("Среднее значение: "+(Float)average);
        }
    }
}
