class Solution {
    public int[] validSequence(String w1, String w2) {
        int n = w1.length(), m = w2.length();
        int[] suf = new int[n + 1], ans = new int[m];

        for (int i = n - 1, j = m - 1; i >= 0; i--) {
            suf[i] = suf[i + 1];
            if (j >= 0 && w1.charAt(i) == w2.charAt(j)) {
                suf[i]++;
                j--;
            }
        }

        int i = 0, j = 0, k = 0;
        boolean changed = false;

        while (i < n && j < m) {
            if (w1.charAt(i) == w2.charAt(j)) {
                ans[k++] = i++;
                j++;
            } 
            else if (!changed && suf[i + 1] >= m - j - 1) {
                ans[k++] = i++;
                j++;
                changed = true;
            } 
            else {
                i++;
            }
        }

        return k == m ? ans : new int[0];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna