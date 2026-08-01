class Solution {
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        TreeMap<Integer,Integer> freq = new TreeMap<>();
        for(int i=0;i<n;i++){
            int x = nums[i];
            if(freq.containsKey(x)) freq.put(x, freq.get(x)+1);
            else freq.put(x, 1);
        }

        int m = freq.size();
        int[] keys = new int[m];
        int idx = 0;
        for(var entry : freq.entrySet()){
            keys[idx] = entry.getKey();
            idx++;
        }

        int ans = 0, suffix = 0;
        for(int i=m-1;i>=0;i--){
            int val = keys[i];
            int cnt = freq.get(val);
            if(suffix >= k) ans += cnt;
            suffix += cnt;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna