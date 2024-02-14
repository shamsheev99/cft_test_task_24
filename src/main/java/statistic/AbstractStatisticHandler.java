package statistic;

import org.apache.log4j.Logger;

public abstract class AbstractStatisticHandler {
    private static final Logger log = Logger.getLogger(AbstractStatisticHandler.class);
    protected boolean statisticFlag;
    protected int count = 0;
    protected Object min;
    protected Object max;
    protected Object average;
    protected Object sum;

    public AbstractStatisticHandler(boolean statisticFlag) {
        this.statisticFlag = statisticFlag;
        log.debug("Created with statisticFlag: " + statisticFlag);
    }

    public abstract void pushStatistic(Object value);


    public abstract void printStatistic();

}
