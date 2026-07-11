class Solution {
    public int firstUniqChar(String s) {
        int n=s.length();
        HashMap<Character,Integer>map=new HashMap<>();
        //friq count
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);

        }
        //first unique
        for(int i=0;i<n;i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
        
    }
}