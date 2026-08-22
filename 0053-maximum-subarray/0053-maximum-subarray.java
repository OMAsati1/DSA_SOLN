class Solution {
    public int maxSubArray(int[] nums) {
        int currSum=0,ans=Integer.MIN_VALUE;
        for(int i : nums){
            currSum+=i;
            ans=Math.max(currSum,ans);
            if(currSum<0) currSum=0;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna