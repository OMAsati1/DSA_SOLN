class Solution {
    public int[] mostCompetitive(int[] nums, int k) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < nums.length; i++) {

            while (!st.isEmpty()
                    && st.peek() > nums[i]
                    && st.size() - 1 + (nums.length - i) >= k) {
                st.pop();
            }

            if (st.size() < k)
                st.push(nums[i]);
        }

        int[] ans = new int[k];

        for (int i = k - 1; i >= 0; i--)
            ans[i] = st.pop();

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna