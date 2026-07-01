class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int ans = 0;

        for (int peak = 1; peak < n - 1; peak++) {

            // Check if current index is a peak
            if (arr[peak] > arr[peak - 1] && arr[peak] > arr[peak + 1]) {

                int left = peak;
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }

                int right = peak;
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                ans = Math.max(ans, right - left + 1);
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna