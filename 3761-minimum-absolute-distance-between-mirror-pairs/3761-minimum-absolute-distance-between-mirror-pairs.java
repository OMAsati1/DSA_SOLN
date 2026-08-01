class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>(); // reverseValue -> last index jaha ye reverse value banega
        int ans = -1;

        for(int j=0;j<n;j++){
            if(map.containsKey(nums[j])){
                int i = map.get(nums[j]);
                int dist = j - i;
                if(ans == -1 || dist < ans) ans = dist;
            }
            int rev = reverse(nums[j]);
            map.put(rev, j); // overwrite -> closest wala index rakho, minimum distance ke liye
        }
        return ans;
    }

    int reverse(int x){
        int rev = 0;
        while(x > 0){
            rev = rev*10 + x%10;
            x /= 10;
        }
        return rev;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna