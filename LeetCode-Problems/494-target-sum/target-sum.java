class Solution {
    private int offset;
    public int solve(int[] nums,int idx,int currsum, int target,Integer[][] dp){
        if(idx==nums.length) return currsum==target?1:0;
        if(dp[idx][currsum+offset]!=null) return dp[idx][currsum+offset];
        int pos=solve(nums, idx+1, currsum+nums[idx], target,dp);
        int neg=solve(nums, idx+1, currsum-nums[idx], target, dp);
        return dp[idx][currsum+offset]=pos+neg;
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        if(Math.abs(target)>totalSum){
            return 0;
        }
        this.offset=totalSum;
        Integer[][] dp=new Integer[nums.length][2*totalSum+1];
        return solve(nums, 0,0, target, dp);
    }
}