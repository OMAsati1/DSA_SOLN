class Solution {
    public int findMaxVal(int n, int[][] rest, int[] diff) {
        long[] arr = new long[n];
        arr[0] = 0;


        Map<Integer, Integer> map = new HashMap<>();
        for (int[] r : rest) {
            map.put(r[0], r[1]);
        }

        for (int i = 1; i < n; i++) {
           arr[i] = arr[i-1] + diff[i-1];
         if (map.containsKey(i)) {
             arr[i] = Math.min(arr[i], map.get(i));
         }
        }

        for (int i = n - 2; i >= 0; i--) {
            arr[i] = Math.min(arr[i], arr[i+1] + diff[i]);
        }

        long max = 0;
        for (long val : arr) {
            max = Math.max(max, val);
        }
        return (int) max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna