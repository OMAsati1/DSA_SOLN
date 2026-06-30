class Solution {
    int mod = (int)1e9 + 7;

    public int countHomogenous(String s) {

        long ans = 1;
        long cnt = 1;

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1))
                cnt++;
            else
                cnt = 1;

            ans = (ans + cnt) % mod;
        }

        return (int) ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna