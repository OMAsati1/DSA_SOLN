class Solution {

    public String reverseWords(String s) {

        String[] words = s.split(" ");

        int target = countVowels(words[0]);

        StringBuilder ans = new StringBuilder();

        ans.append(words[0]);
        if(words.length!=1) ans.append(" ");

        for (int i = 1; i < words.length; i++) {

            if (countVowels(words[i]) == target) {
                words[i] = reverse(words[i]);
            }

            ans.append(words[i]);

            if (i != words.length - 1)
             ans.append(" ");
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

        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna