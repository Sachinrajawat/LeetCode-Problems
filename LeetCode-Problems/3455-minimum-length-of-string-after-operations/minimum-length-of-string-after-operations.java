class Solution {
    public int minimumLength(String s) {
        
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        int count=s.length();
        for(var key:map.keySet()){
            int value=map.get(key);
            while(value>2){
                value-=2;
                count-=2;
            }
        }
        return count;
    }
}