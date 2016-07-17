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
public class TenisConverterTest {
    private String validResult = "Tenis: {teamAName='Anna Karolina Schmiedlova', teamBName='Varvara Lepchenko', teamAScore='40', teamBScore='Adv', teamAGames='1', teamBGames='1', teamBServing='true', scoreboard: { elements: [ { title: 'Sets', teamAScore:'1', teamBScore='0'} ] } }";
    private String validResult2 = "Tenis: {teamAName='Anna Karolina Schmiedlova', teamBName='Varvara Lepchenko', teamAScore='40', teamBScore='Adv', teamAGames='1', teamBGames='1', teamBServing='false', scoreboard: { elements: [ { title: 'Sets', teamAScore:'1', teamBScore='0'} ] } }";
    private String validInput = "Anna Karolina Schmiedlova (1) 1 40-Adv 1 (0) *Varvara Lepchenko";
    private String invalidInput1 = "Pittsburgh Steelers 3-7 Minnesota Vikings 3rd Quarter";
    private String invalidInput2 = "F.C. Barcelona 3-2 Real Madrid";
    private String validInput2 = "Anna Karolina Schmiedlova (1) 1 40-Adv 1 (0) Varvara Lepchenko";

    @Autowired
    private TenisConverter converter;

    @Test
    public void testValidInput() {
        converter.setInputToProcess(validInput);
        Sport convertInputToSport = converter.convertInputToSport();
        assertEquals(validResult, convertInputToSport.toString());
    }

    @Test
    public void testValidInput2() {
        converter.setInputToProcess(validInput2);
        Sport convertInputToSport = converter.convertInputToSport();
        assertEquals(validResult2, convertInputToSport.toString());
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
