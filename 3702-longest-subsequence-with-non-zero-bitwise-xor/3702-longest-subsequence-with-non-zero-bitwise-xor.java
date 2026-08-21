class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int totalXor = 0;
        boolean hasNonZero = false;

        for(int num : nums){
            totalXor ^= num;
            if(num != 0) hasNonZero = true;
        }

        if(totalXor != 0) return n;
        else if(hasNonZero) return n - 1;
        else return 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna