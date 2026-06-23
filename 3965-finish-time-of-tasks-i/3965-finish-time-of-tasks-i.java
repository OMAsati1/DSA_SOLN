class Solution {

    public long finishTime(int n, int[][] edges, int[] baseTime) {

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
        }

        return dfs(0, adj, baseTime);
    }

    long dfs(int node, List<Integer>[] adj, int[] baseTime) {

        if (adj[node].isEmpty()) {
            return baseTime[node];
        }

        long mn = Long.MAX_VALUE;
        long mx = Long.MIN_VALUE;

        for (int child : adj[node]) {
            long t = dfs(child, adj, baseTime);

            mn = Math.min(mn, t);
            mx = Math.max(mx, t);
        }

        long ownDuration = (mx - mn) + baseTime[node];

        return mx + ownDuration;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna