class Solution {
    public int count =0;
    public void solve(int[] nums, int target, int idx){
        if(idx==nums.length && target==0){
            count++;
            return;
        }
        if(idx>=nums.length) return;
        solve(nums,target+nums[idx],idx+1);
        solve(nums,target-nums[idx],idx+1);
    }
    public int findTargetSumWays(int[] nums, int target) {
        solve(nums, target,0);
        return count;
    }
}