class Solution {
    public int solve(int[] nums,int idx, int prev,int[][] dp){
        if(idx>=nums.length) return 0;
        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];
        int skip=solve(nums,idx+1,prev, dp);
        int take=0;
        if(prev==-1 || nums[idx]>nums[prev]){
            take=1+solve(nums,idx+1,idx, dp);
        }
        return dp[idx][prev+1]=Math.max(take,skip);
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][nums.length+1];
        for(int i=0;i<nums.length;i++)
        Arrays.fill(dp[i],-1);
        return solve(nums,0,-1, dp);
    }
}