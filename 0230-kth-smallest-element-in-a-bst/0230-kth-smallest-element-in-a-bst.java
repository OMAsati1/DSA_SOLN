class Solution {
    int ans;
    int k;

    void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (--k == 0) {
            ans = root.val;
            return;
        }

        inorder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna