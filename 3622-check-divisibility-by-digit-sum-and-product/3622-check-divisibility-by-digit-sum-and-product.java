class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0,product=1;
        int tmp=n;
        while(tmp>0){
            int rem = tmp%10;
            sum+=rem;
            product*=rem;
            tmp/=10;
        }
        return n%(sum+product)==0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna