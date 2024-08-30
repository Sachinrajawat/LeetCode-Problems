class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }
        Map<Integer,ArrayList<Character>> Treemap=new TreeMap<>(Collections.reverseOrder());
        for(var key:map.keySet()){
            if(!Treemap.containsKey(map.get(key))){
                ArrayList<Character> a=new ArrayList<>();
                a.add(key);
                Treemap.put(map.get(key),a);
            }
            else{
                ArrayList<Character> a=Treemap.get(map.get(key));
                a.add(key);
                Treemap.put(map.get(key),a);
            }
        }
        System.out.println(map);
        System.out.println(Treemap);
        String ans="";
        for(var key:Treemap.keySet()){
            ArrayList<Character> a=Treemap.get(key);
           System.out.println(a);
                for(int i=0;i<a.size();i++){
                    int newKey=key;
                    while(newKey>0){
                    ans+=a.get(i);
                    newKey--;
                    }
                    
                }

            
        }
        return ans;
    }
}