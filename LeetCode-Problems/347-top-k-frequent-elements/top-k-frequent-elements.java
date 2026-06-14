class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        // System.out.println(map);
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(var key:map.keySet()){
            int[] arr=new int[]{key, map.get(key)};
            queue.add(arr);
        }
        int[] ans=new int[k];
        while(k>0){
            int[] array=queue.remove();
            // System.out.println(array[0]+" "+array[1]);
            ans[k-1]=array[0];
            k--;
        }
        return ans;
    }
}