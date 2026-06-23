class Solution {
    public int maxIceCream(int[] costs, int coins) {

        int[] freq = new int[100001];

        for (int x : costs)
            freq[x]++;

        int ans = 0;

        for (int cost = 1; cost <= 100000; cost++) {

            if (freq[cost] == 0)
                continue;

            int canBuy = Math.min(freq[cost], coins / cost);

            ans += canBuy;
            coins -= canBuy * cost;

            if (coins < cost)
                break;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna