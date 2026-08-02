class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        int total = 0;
        for (int x : cardPoints) {
            total += x;
        }

        if (k == n) {
            return total;
        }

        int window = n - k;

        int i = 0;
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (j < n) {

            sum += cardPoints[j];

            if (j - i + 1 < window) {
                j++;
            } 
            else if (j - i + 1 == window) {

                min = Math.min(min, sum);

                sum -= cardPoints[i];
                i++;
                j++;
            }
        }

        return total - min;
    }
}