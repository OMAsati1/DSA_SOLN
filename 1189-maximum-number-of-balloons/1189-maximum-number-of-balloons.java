class Solution {
    public int maxNumberOfBalloons(String text) {

        int[] need = new int[26];
        need['b' - 'a'] = 1;
        need['a' - 'a'] = 1;
        need['l' - 'a'] = 2;
        need['o' - 'a'] = 2;
        need['n' - 'a'] = 1;

        int[] freq = new int[26];

        // Count characters in text
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i) - 'a']++;
        }

        int ans = Integer.MAX_VALUE;

        // Check only required characters
        ans = Math.min(ans, freq['b' - 'a'] / need['b' - 'a']);
        ans = Math.min(ans, freq['a' - 'a'] / need['a' - 'a']);
        ans = Math.min(ans, freq['l' - 'a'] / need['l' - 'a']);
        ans = Math.min(ans, freq['o' - 'a'] / need['o' - 'a']);
        ans = Math.min(ans, freq['n' - 'a'] / need['n' - 'a']);

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna