class Solution {
    public long minMoves(int[] balance) {
        int n = balance.length;

        long sum = 0;
        int negIdx = -1;

        for (int i = 0; i < n; i++) {
            sum += balance[i];
            if (balance[i] < 0)
                negIdx = i;
        }

        if (sum < 0)
            return -1;

        if (negIdx == -1)
            return 0;

        long ans = 0;
        int need = -balance[negIdx];


            for(int d=1;d<=n/2 && need>0;d++){

            int left = (negIdx-d+n)%n;
            int right = (negIdx+d)%n;

            if(balance[left]>0){
                int take = Math.min(balance[left],need);
                ans += 1l*d*take;
                need-=take;
            } 

            if(need==0) break;
            if(left==right) continue;

            if(balance[right]>0){
                int take = Math.min(balance[right],need);
                ans += 1l*d*take;
                need-=take;
            }

            }
            return ans;  
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna