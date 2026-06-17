class Solution {
    public char processStr(String s, long K) {
        int n = s.length();
        long L = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*')
                L = Math.max(L - 1, 0);
             else if(c=='%') continue;  //nothing to do just string rev and continue
            else if (c == '#')
                L *= 2;
            else
                L++;
        }

        if (K >= L)
            return '.';

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '*')
                L++;
            else if (c == '%')
                K = L - K - 1;
            else if (c == '#') {
                L /= 2;
                K = K >= L ? K - L : K;
            } else {
                L--;
            }
                if (L == K)
                    return c;
        }
        return '.';
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna