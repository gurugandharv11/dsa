class Solution {
    public int thirdMax(int[] nums) {

        long f = Long.MIN_VALUE;
        long s = Long.MIN_VALUE;
        long t = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == f || nums[i] == s || nums[i] == t) {
                continue;
            }

            if (nums[i] > f) {
                t = s;
                s = f;
                f = nums[i];
            }
            else if (nums[i] > s) {
                t = s;
                s = nums[i];
            }
            else if (nums[i] > t) {
                t = nums[i];
            }
        }

        if (t == Long.MIN_VALUE) {
            return (int) f;
        }

        return (int) t;
    }
}