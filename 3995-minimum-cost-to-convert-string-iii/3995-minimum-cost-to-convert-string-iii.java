class Solution {

    int INF = (int) 1e9;
    String source, target;
    List<List<String>> rules;
    int[] costs;
    int n;

    Integer[] dp;

    public int minCost(String source, String target,
                       List<List<String>> rules, int[] costs) {

        this.source = source;
        this.target = target;
        this.rules = rules;
        this.costs = costs;
        this.n = source.length();

        dp = new Integer[n + 1];

        int ans = solve(0);

        return ans == INF ? -1 : ans;
    }

    int solve(int idx) {

        if (idx == n)
            return 0;

        if (dp[idx] != null)
            return dp[idx];

        int ans = INF;

        // Don't apply any rule
        if (source.charAt(idx) == target.charAt(idx))
            ans = solve(idx + 1);

        // Try every rule
        for (int i = 0; i < rules.size(); i++) {

            String pattern = rules.get(i).get(0);
            String replacement = rules.get(i).get(1);

            int len = pattern.length();

            if (idx + len > n)
                continue;

            if (!matchPattern(idx, pattern))
                continue;

            if (!matchReplacement(idx, replacement))
                continue;

            int next = solve(idx + len);

            // if (next != INF)
                ans = Math.min(ans,
                        costs[i] + countStars(pattern) + next);
        }

        return dp[idx] = ans;
    }

    boolean matchPattern(int idx, String pattern) {

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);

            if (ch == '*')
                continue;

            if (ch != source.charAt(idx + i))
                return false;
        }

        return true;
    }

    boolean matchReplacement(int idx, String replacement) {

        for (int i = 0; i < replacement.length(); i++) {

            if (replacement.charAt(i) != target.charAt(idx + i))
                return false;
        }

        return true;
    }

    int countStars(String s) {

        int cnt = 0;

        for (char ch : s.toCharArray())
            if (ch == '*')
                cnt++;

        return cnt;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna