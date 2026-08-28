class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n= arr.length;
        int duplicate = -1;
        int missing = -1;
        for(int i=0;i<n;i++){
         int num = Math.abs(arr[i]);
         int idx = num-1;
         
         if (arr[idx] < 0) {
             duplicate = num;
         } else {
             arr[idx] = -arr[idx];
         }
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(duplicate);
        ans.add(missing);

        return ans;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna