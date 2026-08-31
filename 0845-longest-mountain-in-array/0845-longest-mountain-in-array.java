class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int i = 0;
        int len = 0;
        while (i < n - 1) {
            if (arr[i] < arr[i + 1]) {
        boolean inc=true,dec=false;
                int j = i + 1;
                while (j < n - 1 && arr[j + 1] > arr[j]) {
                    j++;
                }
                while (j < n - 1 && arr[j + 1] < arr[j]) {
                    j++;
                    dec=true;
                }
               if(dec && inc) len = Math.max(j - i + 1, len);
            }
            i++;
        }
        return len;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna