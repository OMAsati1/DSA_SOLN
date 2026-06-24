class Solution {
    public int maxDistance(String moves) {
        int n = moves.length();
        int a=0,b=0,c=0,d=0,e=0;
        for(int i=0;i<n;i++){
            if(moves.charAt(i)=='L') a++;
            else if(moves.charAt(i)=='R') b++;
            else if(moves.charAt(i)=='U') c++;
            else if(moves.charAt(i)=='D') d++;
            else e++;
        }
        return Math.abs(a-b)+Math.abs(c-d)+e;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna