class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int comp=target-nums[i];
            if(map.containsKey(comp)){
                ans[1]=map.get(comp);
                ans[0]=i;
                break;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}