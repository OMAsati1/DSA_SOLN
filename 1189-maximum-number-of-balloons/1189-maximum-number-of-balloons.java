class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[26];

        for (char c : text.toCharArray()) {
            cnt[c - 'a']++;
        }

        return Math.min(
                Math.min(cnt['b' - 'a'], cnt['a' - 'a']),
                Math.min(
                    Math.min(cnt['l' - 'a'] / 2, cnt['o' - 'a'] / 2),
                    cnt['n' - 'a']
                )
        );
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna