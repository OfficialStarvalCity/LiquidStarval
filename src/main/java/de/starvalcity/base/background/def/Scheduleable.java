package de.starvalcity.base.background.def;

public interface Scheduleable {

    void setScheduleDelay(long delay);

    long getScheduleDelay(long delay);

    void setRunning();

    void setSleeping();

}
