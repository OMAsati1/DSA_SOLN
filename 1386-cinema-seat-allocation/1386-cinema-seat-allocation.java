class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();

        for(int[] rs : reservedSeats){
            int row = rs[0];
            int col = rs[1];
            rowMap.computeIfAbsent(row, k -> new HashSet<>()).add(col);
        }

        int ans = 0;

        for(Set<Integer> cols : rowMap.values()){
            boolean left = !cols.contains(2) && !cols.contains(3) && !cols.contains(4) && !cols.contains(5);
            boolean right = !cols.contains(6) && !cols.contains(7) && !cols.contains(8) && !cols.contains(9);
            boolean middle = !cols.contains(4) && !cols.contains(5) && !cols.contains(6) && !cols.contains(7);

            if(left && right) ans += 2;
            else if(left || middle || right) ans += 1;
        }

        int emptyRows = n - rowMap.size();
        ans += emptyRows * 2;

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna