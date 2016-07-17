package com.markus.sportium.converter.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractSportConverter {
    private String inputToProcess;
    protected String whiteSpace = "(\\s+)";    // White Space
    protected String teamName = "([a-z][A-Z].*)";
    protected String intScore = "(\\d+)";
    protected String stringTraco = "(\\-)";


    public String getInputToProcess() {
        return inputToProcess;
    }

    public void setInputToProcess(String inputToProcess) {
        this.inputToProcess = inputToProcess;
    }

    public Matcher verifyConverterType(String input) {
        this.inputToProcess = input;
        return getPattern().matcher(input);
    }

    protected abstract Pattern getPattern();
}
