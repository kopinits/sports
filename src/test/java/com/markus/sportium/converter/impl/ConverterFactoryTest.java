package com.markus.sportium.converter.impl;

import com.markus.sportium.beans.AmericanFootball;
import com.markus.sportium.beans.Football;
import com.markus.sportium.beans.Sport;
import com.markus.sportium.beans.Tenis;
import com.markus.sportium.converter.ConverterFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class ConverterFactoryTest {
    private String americanFootballInput = "Pittsburgh Steelers 3-7 Minnesota Vikings 3rd Quarter";
    private String tenisInput = "Anna Karolina Schmiedlova (1) 1 40-Adv 1 (0) *Varvara Lepchenko";
    private String footballInput = "F.C. Barcelona 3-2 Real Madrid";

    @Autowired
    private ConverterFactory converterFactory;

    @Test
    public void testFootballConverterFactory() {
        Sport sport = converterFactory.getConverter(footballInput).convertInputToSport();
        assertEquals(true, sport instanceof Football);
    }

    @Test
    public void testAmericanFootballConverterFactory() {
        Sport sport = converterFactory.getConverter(americanFootballInput).convertInputToSport();
        assertEquals(true, sport instanceof AmericanFootball);
    }

    @Test
    public void testTenisConverterFactory() {
        Sport sport = converterFactory.getConverter(tenisInput).convertInputToSport();
        assertEquals(true, sport instanceof Tenis);
    }
}
