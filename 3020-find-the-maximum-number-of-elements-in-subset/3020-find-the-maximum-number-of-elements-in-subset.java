import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        // Special case for 1
        if (freq.containsKey(1L)) {
            int count = freq.get(1L);
            ans = Math.max(ans, (count % 2 == 0) ? count - 1 : count);
        }

        for (long x : freq.keySet()) {

            if (x == 1) continue;

            long curr = x;
            int len = 0;

            while (freq.getOrDefault(curr, 0) >= 2) {
                len += 2;

                // Prevent overflow
                if (curr > 1000000000L) break;

                curr = curr * curr;

                if (curr > 1000000000000000000L) break;
            }

            if (freq.getOrDefault(curr, 0) >= 1) {
                len++;
            } else {
                len--;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}