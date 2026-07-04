class Solution {
    public ArrayList<Integer> commonSlot(int[][] s1, int[][] s2, int d) {
        // code here
        Arrays.sort(s1, (a,b)->a[0]-b[0]);
        Arrays.sort(s2, (a,b)->a[0]-b[0]);

        int i=0,j=0;

        while(i<s1.length && j<s2.length){

            int start=Math.max(s1[i][0],s2[j][0]);
            int end=Math.min(s1[i][1],s2[j][1]);

            if(end-start>=d)
                return new ArrayList<>(Arrays.asList(start, start + d));

            if(s1[i][1]<s2[j][1])
                i++;
            else
                j++;
        }

        return new ArrayList<>();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna