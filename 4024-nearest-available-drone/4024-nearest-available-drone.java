class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int ans = -1,min=101;
        for(int i=0;i<drones.length;i++){
            int dist = 0;
            dist = Math.abs(target[0]-drones[i][0])+Math.abs(target[1]-drones[i][1]);
            if(dist<min && dist<=drones[i][2]){
                min = dist;
                ans = i;
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna