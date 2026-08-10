class Solution {
    Boolean[][] memo;

    boolean solve(int n, boolean alice) {
        if (n == 0)
            return !alice;

        int turn = alice ? 1 : 0;

        if (memo[n][turn] != null)
            return memo[n][turn];

        for (int x = 1; x * x <= n; x++) {
            int square = x * x;

            if (solve(n - square, !alice) == alice)
                return memo[n][turn] = alice;
        }

        return memo[n][turn] = !alice;
    }

    public boolean winnerSquareGame(int n) {
        memo = new Boolean[n + 1][2];
        return solve(n, true);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna