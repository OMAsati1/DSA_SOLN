class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String ans ="";
            for(var s : words){
                int val = 0;
                for(var c : s.toCharArray()){
                    val+=(weights[c-'a']);
                }
                val=val%26;
                ans+=(char)('a'+(25-val));
            }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna