class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        for(int i=0;i<n;i++){
        Set<Integer> st = new HashSet<>();
            for(int j=i+1;j<n;j++){
                int rem = -(nums[i]+nums[j]);
                if(st.contains(rem)){
                    List<Integer>ls = new ArrayList<>(List.of(nums[i],nums[j],rem));
                   Collections.sort(ls);
                    ans.add(ls);
                }
                st.add(nums[j]);
            }
        }
        return  new ArrayList<>(ans);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna