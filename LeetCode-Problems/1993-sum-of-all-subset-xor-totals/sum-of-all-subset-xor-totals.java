class Solution {
    public int solve(int[] nums,int idx,int xor){
        if(idx>=nums.length) return xor;
        int take=solve(nums,idx+1,xor^nums[idx]);
        int notTake=solve(nums,idx+1,xor);
        return take+notTake;
    }
    public int subsetXORSum(int[] nums) {
        return solve(nums,0,0);
    }
}