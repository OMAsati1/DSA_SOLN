class Solution {

    int count = 0;

    public int countDominantNodes(TreeNode root) {
        dfs(root);
        return count;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return Integer.MIN_VALUE;

        int leftMax = dfs(node.left);
        int rightMax = dfs(node.right);

        int subtreeMax = Math.max(node.val, Math.max(leftMax, rightMax));

        if (node.val == subtreeMax)
            count++;

        return subtreeMax;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna