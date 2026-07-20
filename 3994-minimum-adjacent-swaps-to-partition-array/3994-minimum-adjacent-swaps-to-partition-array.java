class Solution {
    int mod = 1_000_000_007;

    public int minAdjacentSwaps(int[] nums, int a, int b) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < a) nums[i] = 0;
            else if (nums[i] > b) nums[i] = 2;
            else nums[i] = 1;
        }

        long inv = 0;
        long z = 0, o = 0, t = 0;

        for (int x : nums) {
            if (x == 0) {
                inv = (inv + o + t) % mod;
                z++;
            } else if (x == 1) {
                inv = (inv + t) % mod;
                o++;
            } else {
                t++;
            }
        }

        return (int) inv;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna