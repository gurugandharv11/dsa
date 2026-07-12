class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int n = arr.length;

        int[] temp = arr.clone();   // Original array ki copy
        Arrays.sort(temp);          // Copy ko sort karo

        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;

        // Har unique element ko rank do
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(temp[i])) {
                map.put(temp[i], rank);
                rank++;
            }
        }

        int[] ans = new int[n];

        // Original array ke according rank fill karo
        for (int i = 0; i < n; i++) {
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }
}