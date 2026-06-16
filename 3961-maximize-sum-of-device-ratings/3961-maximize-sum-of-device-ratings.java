class Solution {
    public long maxRatings(int[][] units) {
        int m = units.length;
        int n = units[0].length;

        if(n == 1) {
            long ans = 0;
            for(int[] r : units) ans += r[0];
            return ans;
        }

        int globalMin = Integer.MAX_VALUE;
        long secondSum = 0;

        int[] second = new int[m];

        for(int i = 0; i < m; i++) {

            int mn1 = Integer.MAX_VALUE;
            int mn2 = Integer.MAX_VALUE;

            for(int x : units[i]) {
                if(x < mn1) {
                    mn2 = mn1;
                    mn1 = x;
                } else if(x < mn2) {
                    mn2 = x;
                }
            }

            globalMin = Math.min(globalMin, mn1);
            second[i] = mn2;
            secondSum += mn2;
        }

        long ans = 0;

        for(int i = 0; i < m; i++) {
            ans = Math.max(ans,
                    secondSum - second[i] + globalMin);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna