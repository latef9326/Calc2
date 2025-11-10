

import org.example.HRCalculator;
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

    @Test
    public void testAllWorkoutZones() {
        // Test age 40, maxHR = 180
        assertEquals("Very Light", HRCalculator.getWorkoutZone(40, 80));   // 44%
        assertEquals("Light", HRCalculator.getWorkoutZone(40, 100));       // 56%
        assertEquals("Moderate", HRCalculator.getWorkoutZone(40, 120));    // 67%
        assertEquals("Hard", HRCalculator.getWorkoutZone(40, 140));        // 78%
        assertEquals("Very Hard", HRCalculator.getWorkoutZone(40, 150));   // 83%
        assertEquals("Maximum", HRCalculator.getWorkoutZone(40, 170));     // 94%
    }

    @Test
    public void testWorkoutZoneBoundaries() {
        // Test exact boundaries for age 20 (maxHR = 200)
        assertEquals("Very Light", HRCalculator.getWorkoutZone(20, 99));   // 49.5%
        assertEquals("Light", HRCalculator.getWorkoutZone(20, 100));       // 50%
        assertEquals("Moderate", HRCalculator.getWorkoutZone(20, 120));    // 60%
        assertEquals("Hard", HRCalculator.getWorkoutZone(20, 140));        // 70%
        assertEquals("Very Hard", HRCalculator.getWorkoutZone(20, 160));   // 80%
        assertEquals("Maximum", HRCalculator.getWorkoutZone(20, 180));     // 90%
    }

    @Test
    public void testWorkoutZoneEdgeCases() {
        // Test edge cases - age 30 (maxHR = 190)
        assertEquals("Very Light", HRCalculator.getWorkoutZone(30, 94));   // 49.5%
        assertEquals("Light", HRCalculator.getWorkoutZone(30, 95));        // 50%
        assertEquals("Moderate", HRCalculator.getWorkoutZone(30, 114));    // 60%
        assertEquals("Hard", HRCalculator.getWorkoutZone(30, 133));        // 70%
        assertEquals("Very Hard", HRCalculator.getWorkoutZone(30, 152));   // 80%
        assertEquals("Maximum", HRCalculator.getWorkoutZone(30, 171));     // 90%
    }
}