class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;

        int[] diff = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (lights[i] > 0) {
                int l = Math.max(0, i - lights[i]);
                int r = Math.min(n - 1, i + lights[i]);

                diff[l]++;
                if (r + 1 < n) diff[r + 1]--;
            }
        }

        boolean[] covered = new boolean[n];

        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += diff[i];
            covered[i] = cur > 0;
        }

        int ans = 0;
        int i = 0;

        while (i < n) {

            if (covered[i]) {
                i++;
                continue;
            }

            ans++;

            int pos = Math.min(i + 1, n - 1);

            int reach = Math.min(n - 1, pos + 1);

            i = reach + 1;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna