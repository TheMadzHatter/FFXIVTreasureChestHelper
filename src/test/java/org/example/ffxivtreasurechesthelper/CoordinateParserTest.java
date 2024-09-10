package org.example.ffxivtreasurechesthelper;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateParserTest {

    @Test
    public void stringToCoordinateParseTest(){
        String input = "Kozamauka (36.7, 7.3)";
        CoordinateParser parser = new CoordinateParser();
        Coordinate cord = parser.parseUserInput(input);
        Coordinate expected = new Coordinate(Zone.Kozamauka, 36.7, 7.3);
        assertEquals(cord.getZone(), expected.getZone());
        assertEquals(expected.getX(), cord.getX(), 0.0f);
        assertEquals(expected.getY(), cord.getY() , 0.0f);
    }
}
