class Solution {
    public static ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> ans = new ArrayList<>();
        ans.add(null); // predecessor
        ans.add(null); // successor
        dfs(root, key, ans);
        return ans;
    }
    
    public static void dfs(Node node, int key, ArrayList<Node> ans){
        if(node == null) return;
        
        if(node.data > key){
            ans.set(1, node);       // candidate successor
            dfs(node.left, key, ans);
        } else if(node.data < key){
            ans.set(0, node);       // candidate predecessor
            dfs(node.right, key, ans);
        } else {
            // node.data == key, predecessor is max of left subtree, successor is min of right subtree
            dfs(node.left, key, ans);   // will update predecessor via a helper
            dfs(node.right, key, ans);  // will update successor via a helper
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna