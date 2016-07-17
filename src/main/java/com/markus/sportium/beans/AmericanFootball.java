package com.markus.sportium.beans;

public class AmericanFootball extends Sport {
    private String currentPeriod;

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(String currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("American Football: ");
        sb.append(super.toString());
        sb.append(", currentPeriod='").append(getCurrentPeriod()).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
