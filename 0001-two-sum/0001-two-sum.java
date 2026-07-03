class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int[2];
        HashMap<Integer,Integer>mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int rem = target-nums[i];
            if(mp.containsKey(rem)){
                return new int[]{mp.get(rem),i};
            }
            mp.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna