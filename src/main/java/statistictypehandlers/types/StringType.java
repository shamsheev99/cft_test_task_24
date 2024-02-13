package statistictypehandlers.types;

import statistictypehandlers.AbstractProcessing;

public class StringType extends AbstractProcessing {
    public StringType(boolean statisticType) {
        super(statisticType);
        min = Integer.MAX_VALUE;
        max = 0;
    }

    @Override
    public void pushStatistic(Object value) {
        String data = (String)value;
        count++;
        if ((Integer)min > data.length()) min = data.length();
        if ((Integer)max < data.length()) max = data.length();
    }

    @Override
    public void printStatistic() {
        System.out.println("-----------------------------------------------");
        System.out.println("Количество элементов типа String: " + count);
        if (statisticFlag) {
            System.out.println("Минимальная длина строки: "+(Integer)min);
            System.out.println("Максимальная длина строки: "+(Integer)max);
        }
    }
}
