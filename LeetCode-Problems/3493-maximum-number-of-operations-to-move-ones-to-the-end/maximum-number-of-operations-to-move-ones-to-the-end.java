class Solution {
    public int maxOperations(String s) {
        int size=s.length();
        int count1=0;
        int[] arr=new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') count1++;
            arr[i]=count1;
        }
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
         for(int i=0;i<s.length();i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(var key:map.keySet()){
            if(map.get(key)>1) count+=key;
        }
        return count;
    }
}