class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<arr.length;i++){
            // map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            set.add(arr[i]);
        }
        System.out.println(set);
        int i=1;
        for(int k:set){
            map.put(k,i++);
        }
        System.out.println(map);
        for(int j=0;j<arr.length;j++){
            arr[j]=map.get(arr[j]);
        }
        return arr;
    }
}