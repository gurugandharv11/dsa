class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n=words.length;
        String m="";
        for(int i=0;i<n;i++){
            int jor=0;
            for(int j=0; j<words[i].length();j++){
                jor+=weights[words[i].charAt(j)-'a'];
            }
            m+=(char)('z'- (jor%26));
            
            
        }
        return m;
        
        
    }
}