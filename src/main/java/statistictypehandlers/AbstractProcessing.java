package statistictypehandlers;

import java.util.HashMap;

public abstract class AbstractProcessing {
    protected boolean statisticFlag;
    protected int count = 0;
    protected Object min;
    protected Object max;
    protected Object average;
    protected Object sum;

    public AbstractProcessing(boolean statisticFlag) {
        this.statisticFlag = statisticFlag;
    }

    public abstract void pushStatistic(Object value);


    public abstract void printStatistic();

}
