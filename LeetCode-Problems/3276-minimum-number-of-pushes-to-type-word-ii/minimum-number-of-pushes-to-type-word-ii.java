class Solution {
    public int minimumPushes(String word) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        System.out.println(map);
        TreeMap<Integer,ArrayList> revMap=new TreeMap<>(Collections.reverseOrder());
        for(var entry:map.entrySet()){
            if(revMap.containsKey(entry.getValue())){
                ArrayList<Character> arr=revMap.get(entry.getValue());
                arr.add(entry.getKey());
                revMap.put(entry.getValue(),arr);
            }
            else{
                ArrayList<Character> arr=new ArrayList<>();
                arr.add(entry.getKey());
                revMap.put(entry.getValue(),arr);
            }
        }
        System.out.println(revMap);
        int push=0;
        ArrayList<Character> newArr=new ArrayList<>();
        for(var entry:revMap.entrySet()){
            ArrayList<Character> arr=entry.getValue();
            for(int i=0;i<arr.size();i++){
                if(!newArr.contains(arr.get(i))) newArr.add(arr.get(i));
                if(newArr.size()<=8) push+=entry.getKey();
                else if(newArr.size()<=16) push+=entry.getKey()*2;
                else if(newArr.size()<=24) push+=entry.getKey()*3;
                else push+=entry.getKey()*4;
            }
        }
        
        
        return push;
    }
}