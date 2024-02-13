package statistic;

public abstract class AbstractStatisticHandler {
    protected boolean statisticFlag;
    protected int count = 0;
    protected Object min;
    protected Object max;
    protected Object average;
    protected Object sum;

    public AbstractStatisticHandler(boolean statisticFlag) {
        this.statisticFlag = statisticFlag;
    }

    public abstract void pushStatistic(Object value);


    public abstract void printStatistic();

}
