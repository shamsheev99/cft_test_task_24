package statistic.types;

import statistic.AbstractStatisticHandler;

public class StringType extends AbstractStatisticHandler {
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
        if ((Integer)min > data.length()) min = data.length();
        if ((Integer)max < data.length()) max = data.length();
    }

    @Override
    public void printStatistic() {
        System.out.println("-----------------------------------------------");
        System.out.println("Количество элементов типа String: " + count);
        if (statisticFlag) {
            System.out.println("Минимальная длина строки: "+min);
            System.out.println("Максимальная длина строки: "+max);
        }
    }
}
