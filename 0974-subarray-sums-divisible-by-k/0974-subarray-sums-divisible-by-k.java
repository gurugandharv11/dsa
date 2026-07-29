class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefix = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            prefix += nums[i];

            int need = ((prefix % k) + k) % k;

            if (map.containsKey(need)) {
                count += map.get(need);
            }

            map.put(need, map.getOrDefault(need, 0) + 1);
        }

        return count;
    }
}