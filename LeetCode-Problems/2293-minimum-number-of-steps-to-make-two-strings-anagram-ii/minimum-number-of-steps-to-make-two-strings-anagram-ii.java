class Solution {
    public HashMap freq(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }
        return map;
    }
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> map1=freq(s);
        HashMap<Character,Integer> map2=freq(t);
        System.out.println(map1);
        System.out.println(map2);
        int ans=0;
        for(var key:map1.keySet()){
            if(map2.containsKey(key)){
                ans+=Math.abs(map1.get(key)-map2.get(key));

                map2.remove(key);
            }
            else ans+=map1.get(key);
        }
        for(var key:map2.keySet()){ 
            ans+=map2.get(key);
        }
        return ans;
    }
}