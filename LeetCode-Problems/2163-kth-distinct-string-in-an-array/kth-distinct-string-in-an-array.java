class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> map=new LinkedHashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        // String ans="";
        System.out.println(map);
        int i=0;
        for(var entry:map.entrySet()){
            if(entry.getValue()==1){
                i++;
                if(i==k){
                return entry.getKey();
                }
            }
        }
        return "";
    }
}