class Solution {

    public String reverseWords(String s) {

        String[] words = s.split(" ");

        int target = countVowels(words[0]);

        StringBuilder ans = new StringBuilder(words[0]);

        for (int i = 1; i < words.length; i++) {

            ans.append(" ");

            if (countVowels(words[i]) == target)
                ans.append(reverse(words[i]));
            else
                ans.append(words[i]);
        }

        return ans.toString();
    }

    private int countVowels(String str) {
        int cnt = 0;
        for (char ch : str.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                cnt++;
        }
        return cnt;
    }

    private String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna