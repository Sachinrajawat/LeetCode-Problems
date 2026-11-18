class Solution {
    public int solve(int[] nums,int idx, int target){
        if(target==0 && idx==nums.length) return 1;
        if(idx>=nums.length) return 0;
        int pos=solve(nums, idx+1, target-nums[idx]);
        int neg=solve(nums, idx+1, target+nums[idx]);
        return pos+neg;
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, target);
    }
}