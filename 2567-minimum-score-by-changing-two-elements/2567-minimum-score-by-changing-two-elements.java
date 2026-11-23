class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int case1 = nums[n-1] - nums[2];
        int case2 = nums[n-2] - nums[1];
        int case3 = nums[n-3] - nums[0];

        return Math.min(case1, Math.min(case2, case3));
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna