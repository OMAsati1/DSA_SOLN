class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    boolean helper(TreeNode node, Long min, Long max) {
        if (node == null) return true;
        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;
        return helper(node.left, min, (long) node.val) && helper(node.right, (long) node.val, max);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna