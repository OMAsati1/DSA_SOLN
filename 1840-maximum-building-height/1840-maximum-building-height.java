class Solution {
    public int maxBuilding(int n, int[][] restrictions) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 0);

        for (int[] r : restrictions) {
            map.put(r[0], r[1]);
        }

        // Add last building if not present
        map.putIfAbsent(n, Integer.MAX_VALUE);

        int m = map.size();
        int[] idx = new int[m];
        int[] h = new int[m];

        int k = 0;
        for (var e : map.entrySet()) {
            idx[k] = e.getKey();
            h[k] = e.getValue();
            k++;
        }

        // Forward pass
        for (int i = 1; i < m; i++) {
            h[i] = Math.min(h[i], h[i - 1] + (idx[i] - idx[i - 1]));
        }

        // Backward pass
        for (int i = m - 2; i >= 0; i--) {
            h[i] = Math.min(h[i], h[i + 1] + (idx[i + 1] - idx[i]));
        }

        int ans = 0;

        // Find maximum peak
        for (int i = 1; i < m; i++) {
            int dist = idx[i] - idx[i - 1];
            ans = Math.max(ans, (h[i - 1] + h[i] + dist) / 2);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna