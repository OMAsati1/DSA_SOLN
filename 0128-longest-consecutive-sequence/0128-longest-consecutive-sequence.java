class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(n==0){
            return 0;
        }
        int length=1,c=0,lastSmaller=(int)1e5+1;
        for(int i=0;i<n;i++){
            if(nums[i]-1==lastSmaller){
                c+=1;
                lastSmaller=nums[i];
            }
            else if(nums[i]!=lastSmaller){
                c=1;
                lastSmaller=nums[i];
            }
            length=Math.max(length,c);
        }
        return length;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna