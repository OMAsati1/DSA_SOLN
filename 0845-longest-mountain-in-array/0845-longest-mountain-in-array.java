class Solution {
    public int longestMountain(int[] arr) {

        int n = arr.length;
        int i = 0, ans = 0;

        while (i < n - 1) {

            // increasing hona chahiye
            if (arr[i] >= arr[i + 1]) {
                i++;
                continue;
            }

            int j = i;

            // up
            while (j < n - 1 && arr[j] < arr[j + 1])
                j++;

            int peak = j;

            // down
            while (j < n - 1 && arr[j] > arr[j + 1])
                j++;

            // down nahi hua => mountain nahi hai
            if (j > peak)
                ans = Math.max(ans, j - i + 1);

            i = (j == peak) ? j + 1 : j;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna