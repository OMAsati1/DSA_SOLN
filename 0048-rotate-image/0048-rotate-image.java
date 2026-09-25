class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {

                int temp = matrix[i][j];

                // Left -> Top
                matrix[i][j] = matrix[n - 1 - j][i];

                // Bottom -> Left
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];

                // Right -> Bottom
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];

                // Top -> Right
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna