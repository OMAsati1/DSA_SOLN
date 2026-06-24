class Solution {

    int firstDigit(long num) {
        while (num >= 10) num /= 10;
        return (int) num;
    }

    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            long sum = 0;

            for (int j = i; j < n; j++) {
                sum += nums[j];

                int last = (int)(sum % 10);
                int first = firstDigit(sum);

                if (first == x && last == x)
                    ans++;
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna