class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c=='#'){
                sb.append(sb.toString());
            }
            else if(c=='%'){
                sb.reverse();
            }
            else if(c=='*'){
                if(sb.length()==0) continue;
                sb.deleteCharAt(sb.length() - 1);
            }
            else sb.append(c);
        }
        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna