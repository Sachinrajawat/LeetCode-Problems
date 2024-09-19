class Solution {
    public int firstMissingPositive(int[] nums) {
        Map<Integer,Integer> map=new TreeMap<>();
        long max=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                if(max<nums[i]) max=nums[i];
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        for(int i=1;i<=max+1;i++){
            if(!map.containsKey(i)) return i;
        }

        return 0;
    }
}