class Solution {
public:
    long long maximumValue(int n, int s, int m) {
        
        if(n==1) return s;
        long long inc=n/2;
        long long ans=(1LL*s+inc*m)-(inc-1);
        return ans;
    }
};

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna