class TreeAncestor {
    int col;
    int[][] ancestor;
    public TreeAncestor(int n, int[] parent) {
        col = (int)(Math.log(n) / Math.log(2)) + 1; 
        ancestor = new int[n][col];
        for(int i=0;i<n;i++){
            for(int j=0;j<col;j++){
                ancestor[i][j]=-1;
            }
        }
        for(int i=0;i<n;i++){
            ancestor[i][0]=parent[i];
        }

        for(int i=1;i<col;i++){
            for(int j=0;j<n;j++){
                if(ancestor[j][i-1]!=-1) ancestor[j][i] = ancestor[ancestor[j][i-1]][i-1]; 
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for(int i=0;i<col;i++){
            if((k & (1<<i))!=0){
                node = ancestor[node][i];
                if(node==-1)
                return -1;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna