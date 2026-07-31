class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLen = 1, maxIdx = 0;

        for (int i = 1; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i] && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                    parent[i] = prev;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        ArrayList<Integer> ls = new ArrayList<>();
        int curr = maxIdx;
        while (curr != -1) {
            ls.add(arr[curr]);
            curr = parent[curr];
        }
        Collections.reverse(ls);
        return ls;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna