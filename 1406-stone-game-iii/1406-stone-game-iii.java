class Solution {
    int solve(int[] stoneValue, int person, int idx, int[][] dp){
        if(idx>=stoneValue.length) return 0;
        if(dp[person][idx] != -1) return dp[person][idx];

        int result = person == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int stones = 0;

        for(int x=1;x<=Math.min(stoneValue.length-idx,3);x++){
            stones+=stoneValue[idx+x-1];

           if(person==1) { //alice
            result=Math.max(result,stones+solve(stoneValue,0,idx+x,dp));
            }

            else{//bob
                result=Math.min(result, solve(stoneValue,1,idx+x,dp));
            }
        }
        return dp[person][idx] = result;
    }
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int [][] dp = new int[2][n+1];

        for(var a : dp){
            Arrays.fill(a,-1);
        }

        int aliceScr = solve(stoneValue,1,0,dp);

         int total = 0;
        for (int x : stoneValue)
            total += x;

        int bob = total - aliceScr;

        if (aliceScr > bob)
            return "Alice";
        else if (aliceScr < bob)
            return "Bob";
        else
            return "Tie";
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna