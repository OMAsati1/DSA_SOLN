class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        Map<Long, Integer> mp = new HashMap<>();

        int maxLen = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            long rem = sum - k;

            if (mp.containsKey(rem)) {
                int len = i - mp.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if (!mp.containsKey(sum)) {
                mp.put(sum, i);
            }
        }

        return maxLen;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna