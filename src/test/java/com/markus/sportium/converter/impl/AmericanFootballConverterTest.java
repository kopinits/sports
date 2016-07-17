package com.markus.sportium.converter.impl;

import com.markus.sportium.beans.Sport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class AmericanFootballConverterTest {
    private String validResult = "American Football: {teamAName='Pittsburgh Steelers', teamBName='Minnesota Vikings', teamAScore='3', teamBScore='7', currentPeriod='3rd Quarter'}";
    private String validInput = "Pittsburgh Steelers 3-7 Minnesota Vikings 3rd Quarter";
    private String invalidInput1 = "Anna Karolina Schmiedlova (1) 1 40-Adv 1 (0) *Varvara Lepchenko";
    private String invalidInput2 = "F.C. Barcelona 3-2 Real Madrid";
    private String invalidInput3 = "Pittsburgh Steelers 3-7 Minnesota Vikings 1st";
    private String invalidInput4 = "Pittsburgh Steelers 3-7 Minnesota Vikings 2nd Qua";

    @Autowired
    private AmericanFootballConverter converter;

    @Test
    public void testValidInput() {
        converter.setInputToProcess(validInput);
        Sport convertInputToSport = converter.convertInputToSport();
        assertEquals(validResult, convertInputToSport.toString());
    }

    @Test
    public void testInvalidInput1() {
        converter.setInputToProcess(invalidInput1);
        Sport convertInputToSport = converter.convertInputToSport();
        assertEquals(null, convertInputToSport);
    }

    @Test
    public void testInvalidInput2() {
        converter.setInputToProcess(invalidInput2);
        Sport convertInputToSport = converter.convertInputToSport();
        assertEquals(null, convertInputToSport);
    }

    @Test
    public void testInvalidInput3() {
        converter.setInputToProcess(invalidInput3);
        Sport convertInputToSport = converter.convertInputToSport();
        assertEquals(null, convertInputToSport);
    }

    @Test
    public void testInvalidInput4() {
        converter.setInputToProcess(invalidInput4);
        Sport convertInputToSport = converter.convertInputToSport();
        assertEquals(null, convertInputToSport);
    }
}
