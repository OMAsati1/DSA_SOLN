class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int Maxprefix[] = new int[n];
        int Minsufix[] = new int[n];
        Maxprefix[0]=nums[0];
        for(int i=1;i<n;i++){
            Maxprefix[i]=Math.max(Maxprefix[i-1],nums[i]);
        }
        Minsufix[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            Minsufix[i]=Math.min(Minsufix[i+1],nums[i]);
        }
        for(int i=0;i<n;i++){
            if(Maxprefix[i]-Minsufix[i]<=k) return i;
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna