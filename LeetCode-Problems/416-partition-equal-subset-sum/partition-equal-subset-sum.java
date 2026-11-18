class Solution {
    public int solve(int[] nums,int idx,int target,int[][] dp){
        if(target==0) return 1;
        if(idx>=nums.length) return 0;
        if(dp[idx][target]!=-1) return dp[idx][target];
        int notTake=solve(nums,idx+1, target,dp);
        if(nums[idx]<=target){
            int take=solve(nums, idx+1, target-nums[idx],dp);
            if(take==1) return dp[idx][target]=1;
        }
        return dp[idx][target]=notTake;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums) sum+=num;
        if(sum%2!=0) return false;
        sum/=2;
        int[][] dp=new int[nums.length][sum+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return solve(nums,0 , sum, dp)==1;
    }
}