package com.markus.sportium.converter.impl;

import com.markus.sportium.beans.Sport;
import com.markus.sportium.converter.ISportConverter;
import com.markus.sportium.beans.Tenis;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TenisConverter extends AbstractSportConverter implements ISportConverter {

    @Override
    public Sport convertInputToSport() {
        Tenis tenis = null;
        Matcher m = getPattern().matcher(getInputToProcess());
        if (m.find()) {
            tenis = fillObject(m);
        }
        return tenis;
    }

    @Override
    protected Pattern getPattern() {
        String leftParent = "(\\()";
        String teanSets = "(\\d+)";
        String teanGames = "(\\d+)";
        String rightParen = "(\\))";
        String stringScore = "(.*)";
        String teamBName = "(.*)";
        String teamAName = "(.*)";
        String pattern = teamAName + whiteSpace + leftParent + teanSets + rightParen + whiteSpace + teanGames + whiteSpace + stringScore + stringTraco + stringScore + whiteSpace + teanGames + whiteSpace + leftParent + teanSets + rightParen + whiteSpace + teamBName;
        return Pattern.compile(pattern, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    }

    private Tenis fillObject(Matcher m) {
        Tenis tenis = null;
        if (m != null) {
            tenis = new Tenis();
            tenis.setTeamAName(m.group(1));
            tenis.setTeamASetScore(Integer.valueOf(m.group(4)));
            tenis.setTeamAGames(Integer.valueOf(m.group(7)));
            tenis.setTeamAScore(m.group(9));
            tenis.setTeamBSetScore(Integer.valueOf(m.group(16)));
            tenis.setTeamBGames(Integer.valueOf(m.group(13)));
            tenis.setTeamBScore(m.group(11));
            int index = 0;
            if (m.group(19).substring(0, 1).equals("*")) {
                tenis.setIsServing(true);
                index = 1;
            } else {
                tenis.setIsServing(false);
            }
            tenis.setTeamBName(m.group(19).substring(index));
        }
        return tenis;
    }
}
