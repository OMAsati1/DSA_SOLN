class Solution {
    public long subarrayXor(int nums[], int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();

               map.put(0, 1); 

               int xor = 0;
               long ans = 0;

               for (int num : nums) {

                   xor ^= num;

                   if (map.containsKey(xor^k)) {
                       ans += 1l*map.get(xor^k);
                   }

                   map.put(xor, map.getOrDefault(xor, 0) + 1);
               }

               return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna