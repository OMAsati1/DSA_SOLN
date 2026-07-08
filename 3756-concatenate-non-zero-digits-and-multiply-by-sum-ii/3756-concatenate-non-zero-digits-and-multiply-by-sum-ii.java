class Solution {

    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        long[] prefixSum = new long[n];
        long[] prefixNum = new long[n];
        int[] cntNonZero = new int[n];
        long[] pow10 = new long[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        for (int i = 0; i < n; i++) {

            int d = s.charAt(i) - '0';

            prefixSum[i] = d;
            if (i > 0)
                prefixSum[i] += prefixSum[i - 1];

            cntNonZero[i] = (d != 0 ? 1 : 0);
            if (i > 0)
                cntNonZero[i] += cntNonZero[i - 1];

            if (i == 0) {
                prefixNum[i] = d;
            } else {
                if (d == 0)
                    prefixNum[i] = prefixNum[i - 1];
                else
                    prefixNum[i] = (prefixNum[i - 1] * 10 + d) % MOD;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            long sum = prefixSum[r];
            if (l > 0)
                sum -= prefixSum[l - 1];

            int cnt = cntNonZero[r];
            if (l > 0)
                cnt -= cntNonZero[l - 1];

            long num = prefixNum[r];

            if (l > 0) {
                num = (num - (prefixNum[l - 1] * pow10[cnt]) % MOD + MOD) % MOD;
            }

            ans[i] = (int)((num * (sum % MOD)) % MOD);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna