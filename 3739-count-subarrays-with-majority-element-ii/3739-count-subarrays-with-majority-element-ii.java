class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
          Map<Integer, Integer> mp = new HashMap<>();   

        int currSum = 0;

        mp.put(0, 1); 
        long validLeftPoints = 0;
        long result = 0;
        for (int x : nums) {
            if (x == target) {
                validLeftPoints += mp.getOrDefault(currSum, 0);
                currSum++;
            } else {
                currSum--;
                validLeftPoints -= mp.getOrDefault(currSum, 0);
            }
            mp.merge(currSum, 1, Integer::sum);
            result += validLeftPoints;
        }
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna