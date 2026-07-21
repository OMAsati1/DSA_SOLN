class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        List<Integer> ls = new ArrayList<>();

        int ones = 0;
        int cnt = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                cnt++;
            } else {
                ones++;
                if (cnt != 0) {
                    ls.add(cnt);
                    cnt = 0;
                }
            }
        }

        if (cnt != 0) ls.add(cnt);

        int best = 0;

        for (int i = 0; i + 1 < ls.size(); i++) {
            best = Math.max(best, ls.get(i) + ls.get(i + 1));
        }

        return ones + best;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna