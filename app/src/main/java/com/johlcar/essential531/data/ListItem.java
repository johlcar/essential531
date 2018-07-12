package com.johlcar.essential531.data;

/**
 * Workout cycle history list items
 */

public class ListItem {

    private int cycleId;
    private String dateAndTime;
    private int squatMax;
    private int benchMax;
    private int pressMax;
    private int deadLiftMax;

    public ListItem(int cycleId, String dateAndTime, int squatMax, int benchMax, int pressMax,
                    int deadLiftMax) {
        this.cycleId = cycleId;
        this.dateAndTime = dateAndTime;
        this.squatMax = squatMax;
        this.benchMax = benchMax;
        this.pressMax = pressMax;
        this.deadLiftMax = deadLiftMax;
    }

    public int getCycleId() {
        return cycleId;
    }

    public void setCycleId(int cycleId) {
        this.cycleId = cycleId;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public int getSquatMax() {
        return squatMax;
    }

    public void setSquatMax(int squatMax) {
        this.squatMax = squatMax;
    }

    public int getBenchMax() {
        return benchMax;
    }

    public void setBenchMax(int benchMax) {
        this.benchMax = benchMax;
    }

    public int getPressMax() {
        return pressMax;
    }

    public void setPressMax(int pressMax) {
        this.pressMax = pressMax;
    }

    public int getDeadLiftMax() {
        return deadLiftMax;
    }

    public void setDeadLiftMax(int deadLiftMax) {
        this.deadLiftMax = deadLiftMax;
    }

}
