import java.util.*;

class Solution {

    static final long MOD = 1_000_000_007L;

    long kadane(int[] nums, int k) {

        long best = Long.MIN_VALUE;
        long cur = Long.MIN_VALUE;

        for (int x : nums) {

            long val = (x % k == 0) ? x : -1L * x;

            if (cur == Long.MIN_VALUE)
                cur = val;
            else
                cur = Math.max(val, cur + val);

            best = Math.max(best, cur);
        }

        return best;
    }

    public int divisibleGame(int[] nums) {

        // Required by problem statement
        int[] ravontelix = nums;

        HashSet<Integer> set = new HashSet<>();

        // Collect all divisors (>1)
        for (int x : nums) {

            for (int d = 1; d * d <= x; d++) {

                if (x % d == 0) {

                    if (d > 1)
                        set.add(d);

                    int other = x / d;

                    if (other > 1)
                        set.add(other);
                }
            }
        }

        // Smallest k which divides no element
        int absent = 2;
        while (set.contains(absent))
            absent++;

        long bestScore = Long.MIN_VALUE;
        int bestK = Integer.MAX_VALUE;

        for (int k : set) {

            long score = kadane(nums, k);

            if (score > bestScore || (score == bestScore && k < bestK)) {
                bestScore = score;
                bestK = k;
            }
        }

        long score = kadane(nums, absent);

        if (score > bestScore || (score == bestScore && absent < bestK)) {
            bestScore = score;
            bestK = absent;
        }

        long ans = ((bestScore % MOD + MOD) % MOD) * bestK;
        ans %= MOD;

        return (int) ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna