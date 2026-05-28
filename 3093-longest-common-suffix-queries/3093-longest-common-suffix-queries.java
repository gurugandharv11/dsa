class Solution {
    class TrieNode {
        TrieNode child[];
        int leastLength;
        int leastLengthIndex;

        public TrieNode() {
            child = new TrieNode[26];
            leastLength = Integer.MAX_VALUE;
            leastLengthIndex = -1;
        }

        private void add(String s, int i) { // string, index
            TrieNode cur = this;
            int len = s.length();
            // for empty string
            if(this.leastLength >= len) {
                this.leastLength = len;
                this.leastLengthIndex = i;
            }

            for(int j = len - 1; j >= 0; j--) {
                int ind = s.charAt(j) - 'a';
                if(cur.child[ind] == null) {
                    cur.child[ind] = new TrieNode();
                }

                cur = cur.child[ind];
                if(cur.leastLength >= len) {
                    cur.leastLength = len;
                    cur.leastLengthIndex = i;
                }
            }
        }

        private int search(String s) {
            TrieNode cur = this;

            for(int i = s.length() - 1; i >= 0; i--) {
                int ind = s.charAt(i) - 'a';
                if(cur.child[ind] == null) {
                    return cur.leastLengthIndex;
                }

                cur = cur.child[ind];
            }

            return cur.leastLengthIndex;
        }


    }


    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int n = wordsQuery.length;

        TrieNode root = new TrieNode();

        for(int i = wordsContainer.length - 1; i >= 0; i--) {
            root.add(wordsContainer[i], i);
        }

        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            ans[i] = root.search(wordsQuery[i]);
        }

        return ans;
    }
}