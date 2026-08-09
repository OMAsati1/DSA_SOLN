class Solution {
    int solve(int[] piles, int person, int idx, int M, int[][][] dp){
        if(idx>=piles.length) return 0;
        if(dp[person][idx][M] != -1) return dp[person][idx][M];

        int result = person == 1 ? -1 : Integer.MAX_VALUE;
        int stones = 0;

        for(int x=1;x<=Math.min(piles.length-idx,2*M);x++){
            stones+=piles[idx+x-1];

           if(person==1) { //alice
            result=Math.max(result,stones+solve(piles,0,idx+x,Math.max(M,x),dp));
            }

            else{
                result=Math.min(result, solve(piles,1,idx+x,Math.max(M,x),dp));
            }
        }
        return dp[person][idx][M] = result;
    }
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int [][][] dp = new int[2][n+1][n+1];

        for(var b : dp){
            for(var a : b) Arrays.fill(a,-1);
        }

        return solve(piles,1,0,1,dp);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna