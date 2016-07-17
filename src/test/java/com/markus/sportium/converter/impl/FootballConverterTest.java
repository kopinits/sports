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
public class FootballConverterTest {
    private String validResult = "Football: {teamAName='Barcelona', teamBName='Real Madrid', teamAScore='3', teamBScore='2'}";
    private String validInput = "F.C. Barcelona 3-2 Real Madrid";
    private String invalidInput1 = "Anna Karolina Schmiedlova (1) 1 40-Adv 1 (0) *Varvara Lepchenko";
    private String invalidInput2 = "Pittsburgh Steelers 3-AS Minnesota Vikings Quarter";

    @Autowired
    private FootballConverter converter;

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
}
