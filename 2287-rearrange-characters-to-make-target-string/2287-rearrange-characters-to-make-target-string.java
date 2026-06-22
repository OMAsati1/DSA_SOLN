class Solution {
    public int rearrangeCharacters(String s, String target) {

        int[] freqS = new int[26];
        int[] freqT = new int[26];

        // Count characters in s
        for (char c : s.toCharArray()) {
            freqS[c - 'a']++;
        }

        // Count characters needed in target
        for (char c : target.toCharArray()) {
            freqT[c - 'a']++;
        }

        int ans = Integer.MAX_VALUE;

        // Check every required character
        for (int i = 0; i < 26; i++) {
            if (freqT[i] > 0) {
                ans = Math.min(ans, freqS[i] / freqT[i]);
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna