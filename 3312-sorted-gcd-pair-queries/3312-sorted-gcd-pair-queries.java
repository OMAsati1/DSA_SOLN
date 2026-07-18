class Solution {

    void update(int n, long[] count) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count[i]++;
                if (n / i != i)
                    count[n / i]++;
            }
        }
    }

    void update(long[] count, int n, long cnt) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count[i] += cnt;
                if (n / i != i)
                    count[n / i] += cnt;
            }
        }
    }

    public int[] gcdValues(int[] nums, long[] queries) {

        int n = nums.length;

        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);

        long[] count = new long[max + 1];

        for (int x : nums)
            update(x, count);

        long[] gcdCount = new long[max + 1];

        for (int gcd = max; gcd >= 1; gcd--) {

            long elements = count[gcd];
            long pairs = elements * (elements - 1) / 2;

            long requiredPairs = pairs - gcdCount[gcd];

            if (requiredPairs >= 0) {
                count[gcd] = requiredPairs;
                update(gcdCount, gcd, requiredPairs);
            }
        }

        int m = queries.length;

        long[][] q = new long[m][2];

        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, Comparator.comparingLong(a -> a[0]));

        int[] ans = new int[m];

        long prefix = 0;
        int g = 1;

        for (long[] curr : q) {

            long index = curr[0];
            int originalPos = (int) curr[1];

            while (prefix <= index) {
                prefix += count[g];
                g++;
            }

            ans[originalPos] = g - 1;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna