class Solution {
    int findCeil(Node root, int x) {
        if (root == null) return -1;
        
        if (root.data >= x) {
            int leftResult = findCeil(root.left, x);
            return (leftResult != -1) ? leftResult : root.data;
        } else {
            return findCeil(root.right, x);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna