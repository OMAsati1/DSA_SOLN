class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        for (int cost : costs) {
            if (cost > coins) break;
            ans++;
            coins -= cost;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna