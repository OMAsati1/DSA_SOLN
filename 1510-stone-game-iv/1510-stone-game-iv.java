class Solution {
    int[] memo;

    boolean solve(int n) {
        if (n == 0)
            return false;

        if (memo[n] != -1)
            return memo[n] == 1;

        for (int x = 1; x * x <= n; x++) {
            int square = x * x;

            if (!solve(n - square)) {
                memo[n] = 1;
                return true;
            }
        }

        memo[n] = 0;
        return false;
    }

    public boolean winnerSquareGame(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return solve(n);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna