class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]) return b[0]-a[0];
            else return a[1]-b[1];
        });
        for(var key:map.keySet()){
            pq.add(new int[]{key,map.get(key)});
        }
        int j=0;
        int[] array=new int[nums.length];
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            for(int i=0;i<a[1];i++){
                array[j++]=a[0];
            }
        }
        return array;
    }
}