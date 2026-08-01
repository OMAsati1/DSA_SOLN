class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
       Arrays.sort(nums);
       int n  = nums.length;
       return nums[n-1]+nums[n-2]-nums[0]; 
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna