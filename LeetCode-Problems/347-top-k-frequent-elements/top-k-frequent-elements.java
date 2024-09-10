class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(); 
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums) map.put(i,map.getOrDefault(i,0)+1);
        System.out.println(map);
        TreeMap<Integer,ArrayList<Integer>> Tmap=new TreeMap<>(Collections.reverseOrder());
        for(var key:map.keySet()){
            if(!Tmap.containsKey(map.get(key))){
                ArrayList<Integer> arr=new ArrayList<>();
                arr.add(key);
                Tmap.put(map.get(key),arr);
            }
            else{
                ArrayList<Integer> arr=Tmap.get(map.get(key));
                arr.add(key);
                Tmap.put(map.get(key),arr);
            }
        }
        System.out.println(Tmap);
        int[] ans=new int[k];
        int j=0;
        while(j<k){
            for(var key:Tmap.keySet()){
                ArrayList<Integer> arr=Tmap.get(key);
                for(int i=0;i<arr.size();i++){
                    ans[j++]=arr.get(i);
                    if(j==k) return ans;
                }
            }
        }
        return ans;
    }
}