class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        if (m > n)
            return ans;

        int[] pFreq = new int[26];
        int[] window = new int[26];

        // Frequency of pattern
        for (char ch : p.toCharArray())
            pFreq[ch - 'a']++;

        int i = 0, j = 0;

        while (j < n) {

            // Add current character
            window[s.charAt(j) - 'a']++;

            // Window size becomes m
            if (j - i + 1 == m) {

                if (Arrays.equals(window, pFreq))
                    ans.add(i);

                window[s.charAt(i) - 'a']--;
                i++;
            }

            j++;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna