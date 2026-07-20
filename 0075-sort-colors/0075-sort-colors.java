class Solution {
    void swap(int i,int j, int[] nums){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void sortColors(int[] nums) {
        int low =0,mid=0;
        int high = nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(mid,low,nums);
                mid++;
                low++;
            }
            else if(nums[mid]==1) mid++;

            else if(nums[mid]==2){
                swap(mid,high,nums);
                high--;
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna