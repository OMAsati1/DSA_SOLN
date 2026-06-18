class Solution {
    public double angleClock(int hour, int minutes) {
        double hourAngle = (hour + minutes/60.0)*30.0;
        double minAngle = minutes*6.0;
        double angle = Math.abs(hourAngle-minAngle);
        return Math.min(360.0-angle,angle);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna