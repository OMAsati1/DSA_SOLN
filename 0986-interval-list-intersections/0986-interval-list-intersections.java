class Solution {
    public int[][] intervalIntersection(int[][] fl, int[][] sl) {

        List<int[]> ans = new ArrayList<>();

        int i = 0, j = 0;

        while (i < fl.length && j < sl.length) {

            // First interval completely before second
            if (fl[i][1] < sl[j][0]) {
                i++;
            }
            // Second interval completely before first
            else if (fl[i][0] > sl[j][1]) {
                j++;
            }
            // Overlap
            else {
                int start = Math.max(fl[i][0], sl[j][0]);
                int end = Math.min(fl[i][1], sl[j][1]);

                ans.add(new int[]{start, end});

                if (fl[i][1] < sl[j][1])
                    i++;
                else
                    j++;
            }
        }

        return ans.toArray(new int[0][]);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna