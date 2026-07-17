class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int [2*n];
        int i = 0,j=0;
        while(i<2*n && j<n){
            arr[i]=nums[j];
            i+=2;
            j++;
        }
        i=1;
        j=n;
        while(i<2*n && j<2*n){
            arr[i]=nums[j];
            i+=2;
            j++;
        }
        return arr;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna