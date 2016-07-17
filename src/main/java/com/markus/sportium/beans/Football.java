package com.markus.sportium.beans;

public class Football extends Sport {
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Football: ");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

}
