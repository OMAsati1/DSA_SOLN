class Solution {
    public int longCommSubstr(String s1, String s2) {


        int n = s1.length();
        int m = s2.length();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int len = 0;

                while (i + len < n &&
                       j + len < m &&
                       s1.charAt(i + len) == s2.charAt(j + len)) {

                    len++;
                }

                ans = Math.max(ans, len);
            }
        }

        return ans;
    }
}
    

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna