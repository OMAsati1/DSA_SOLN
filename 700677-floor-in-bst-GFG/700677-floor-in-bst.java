/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int findMaxFork(Node root, int x) {
        // code here.
        if (root == null) return -1;
        
        if (root.data <= x) {
            int leftResult = findMaxFork(root.right, x);
            return (leftResult != -1) ? leftResult : root.data;
        } else {
            return findMaxFork(root.left, x);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna