class Solution {
    private double rec(double x,long n){
        if(n==0) return 1;
        if((n&1)==1){
            return x*rec(x,n-1);
        }
        else return rec(x*x,n/2);
    }
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return rec(x,N);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna