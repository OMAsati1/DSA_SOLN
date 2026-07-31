class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) freq[c - 'a']++;

        Arrays.sort(freq); // ascending

        int total = 0;
        int rank = 0; // position from the top (highest freq = rank 0)
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;
            int pushCost = (rank / 8) + 1;
            total += freq[i] * pushCost;
            rank++;
        }
        return total;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna