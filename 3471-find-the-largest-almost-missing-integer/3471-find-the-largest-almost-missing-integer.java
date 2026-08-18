class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int ans = -1;

        // k == n
        if (k == n) {
            for (int x : nums) {
                ans = Math.max(ans, x);
            }
            return ans;
        }

        // k == 1
        if (k == 1) {
            for (int x : nums) {
                if (freq.get(x) == 1) {
                    ans = Math.max(ans, x);
                }
            }
            return ans;
        }

        // 1 < k < n
        if (freq.get(nums[0]) == 1) {
            ans = Math.max(ans, nums[0]);
        }

        if (freq.get(nums[n - 1]) == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna