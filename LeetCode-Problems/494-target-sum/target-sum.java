class Solution {
    public int count =0;
    public int solve(int[] nums, int target, int idx,HashMap<String,Integer> map){
        if(idx==nums.length){
            return target==0?1:0;
        }
        String key=idx+", "+target;
        if(map.containsKey(key)) return map.get(key);
        int add=solve(nums,target+nums[idx],idx+1,map);
        int sub=solve(nums,target-nums[idx],idx+1,map);
        map.put(key,add+sub);
        return map.get(key);
    }
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> map=new HashMap<>();
        return solve(nums, target,0,map);
    }
}