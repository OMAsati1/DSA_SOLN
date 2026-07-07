class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return b[1] - a[1];
        });
        
        int count = 0;
        int maxEnd = 0;
        
        for (int[] interval : intervals) {
            int end = interval[1];
            
            if (end > maxEnd) {
                count++;
                maxEnd = end;
            }
        }
        
        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna