package com.markus.sportium.converter;

import com.markus.sportium.converter.impl.FootballConverter;
import com.markus.sportium.converter.impl.TenisConverter;
import com.markus.sportium.converter.impl.AmericanFootballConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConverterFactory {

    @Autowired
    private AmericanFootballConverter americanFootballConverter;
    @Autowired
    private FootballConverter footballConverter;
    @Autowired
    private TenisConverter tenisConverter;

    public ISportConverter getConverter(String input) {
        ISportConverter result = null;
        if (tenisConverter.verifyConverterType(input).find()) {
            result = tenisConverter;
        } else if (americanFootballConverter.verifyConverterType(input).find()) {
            result = americanFootballConverter;
        } else if (footballConverter.verifyConverterType(input).find()) {
            result = footballConverter;
        }
        return result;
    }
}
