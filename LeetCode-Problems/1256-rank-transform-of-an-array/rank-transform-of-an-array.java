class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] copy=arr.clone();
        Arrays.sort(copy);
        int rank=1;
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(copy[i])){
                map.put(copy[i],rank++);
            }
        }
        for(int i=0;i<arr.length;i++) arr[i]=map.get(arr[i]);
        
        return arr;
    }
}