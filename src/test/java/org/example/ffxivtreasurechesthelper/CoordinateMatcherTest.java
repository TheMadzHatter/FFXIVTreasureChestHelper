package org.example.ffxivtreasurechesthelper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinateMatcherTest {
    @Test
    public void inputCoordinateToChestCoordinateMatchTest(){
        Coordinate input = new Coordinate(Zone.Kozamauka, 36.7, 7.3);

        Coordinate expected = new Coordinate(Zone.Kozamauka, 36.6, 6.3);

        CoordinateMatcher matcher = new CoordinateMatcher();
        Coordinate cord = matcher.match(input);

        assertEquals(cord.getZone(), expected.getZone());
        assertEquals(expected.getX(), cord.getX(), 0.0f);
        assertEquals(expected.getY(), cord.getY() , 0.0f);
    }
}
