package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HRCalculatorTest {

    @Test
    public void testValidMaxHR() {
        assertEquals(195, HRCalculator.calculateMaxHR(25));
    }

    @Test
    public void testInvalidMinHR_ageTooHigh() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(500));
    }

    @Test
    public void testInvalidMinHR_ageTooLow() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(-1));
    }

    @Test
    public void testWorkoutZones() {
        assertEquals("Very Light", HRCalculator.getWorkoutZone(40, 80));
        assertEquals("Maximum", HRCalculator.getWorkoutZone(40, 200));
    }
}
