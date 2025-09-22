class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int max=0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            max=Math.max(map.get(nums[i]),max);
        }
        int ans=0;
        for(var key:map.keySet()){
            if(map.get(key)==max) ans+=max;
        }
        return ans;
    }
}