class Solution {
    public int subarraySum(int[] arr) {
        // code here
        int sum=0,n=arr.length;
        for(int i=0;i<n;i++){
            sum+=arr[i]*(i+1)*(n-i);
        }
        return sum;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna