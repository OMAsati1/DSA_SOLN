class Solution {
    public int elevatorRequests(int n, int[] req) {
        int ans = req[0];
        for(int i=1;i<req.length;i++){
            ans += Math.abs((req[i]-req[i-1]));
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna