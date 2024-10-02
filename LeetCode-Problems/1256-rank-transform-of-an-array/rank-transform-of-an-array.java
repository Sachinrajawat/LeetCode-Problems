class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        TreeSet<Integer> set=new TreeSet<>();

        for(int i=0;i<arr.length;i++) set.add(arr[i]);
        
        int i=1;
        for(int k:set) map.put(k,i++);

        for(int j=0;j<arr.length;j++) arr[j]=map.get(arr[j]);
        
        return arr;
    }
}