package org.example;

public class HRCalculator {

    public static int calculateMaxHR(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age out of bounds");
        }
        return 220 - age;
    }

    public static String getWorkoutZone(int age, int bpm) {
        int maxHR = calculateMaxHR(age);
        double percent = (bpm / (double) maxHR) * 100;

        if (percent < 50) return "Very Light";
        if (percent < 60) return "Light";
        if (percent < 70) return "Moderate";
        if (percent < 80) return "Hard";
        if (percent < 90) return "Very Hard";
        return "Maximum";
    }
}
