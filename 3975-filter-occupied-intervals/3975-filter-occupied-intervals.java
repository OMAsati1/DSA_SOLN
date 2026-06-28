class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {

        Arrays.sort(occupiedIntervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();

        for (int[] curr : occupiedIntervals) {
            if (merged.isEmpty() || curr[0] > merged.get(merged.size() - 1)[1] + 1) {
                merged.add(new int[]{curr[0], curr[1]});
            } else {
                merged.get(merged.size() - 1)[1] =
                        Math.max(merged.get(merged.size() - 1)[1], curr[1]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int[] in : merged) {

            int l = in[0];
            int r = in[1];

            if (r < freeStart || l > freeEnd) {
                ans.add(Arrays.asList(l, r));
            }
            else {

                if (l < freeStart) {
                    ans.add(Arrays.asList(l, freeStart - 1));
                }

                if (r > freeEnd) {
                    ans.add(Arrays.asList(freeEnd + 1, r));
                }
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna