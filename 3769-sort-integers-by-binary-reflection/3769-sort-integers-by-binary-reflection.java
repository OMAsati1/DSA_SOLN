class Solution {
    public int reverseActualBits(int n) {
        int bitLength = (n == 0) ? 0 : (int)(Math.log(n) / Math.log(2)) + 1;
        int result = 0;
        for (int i = 0; i < bitLength; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }
        return result;
    }

    public int[] sortByReflection(int[] nums) {
        int n = nums.length;
        Integer[] boxed = new Integer[n];
        for (int i = 0; i < n; i++) boxed[i] = nums[i];

        Arrays.sort(boxed, (a, b) -> {
            int ra = reverseActualBits(a);
            int rb = reverseActualBits(b);
            if (ra != rb) return ra - rb;
            return a - b;
        });

        int[] result = new int[n];
        for (int i = 0; i < n; i++) result[i] = boxed[i];
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna