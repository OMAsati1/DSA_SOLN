class Solution {
    public int maxDistinct(String s) {
        HashSet<Character> hash = new HashSet<>();
        for(char c : s.toCharArray()) hash.add(c);
        return hash.size();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna