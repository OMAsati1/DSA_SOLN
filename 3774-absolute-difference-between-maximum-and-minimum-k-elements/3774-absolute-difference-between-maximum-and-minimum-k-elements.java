class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int sumMin = 0,sumMax=0;
        for(int i=0;i<k;i++){
            sumMin+=nums[i];
            sumMax+=nums[n-i-1];
        }
        return Math.abs(sumMin-sumMax);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna