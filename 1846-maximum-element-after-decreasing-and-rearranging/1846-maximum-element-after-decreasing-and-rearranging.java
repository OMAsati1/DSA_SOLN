class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] A) {
        Arrays.sort(A);
        int n = A.length;

        A[0] = 1;
        for (int i = 1; i < n; i++)
            A[i] = Math.min(A[i], A[i - 1] + 1);
        
        return A[n - 1];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna