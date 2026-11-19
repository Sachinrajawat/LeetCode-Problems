class Solution {
    public int solve(int[] nums,int prevIdx, int currIdx, int[][] dp){
        if(prevIdx!=-1 && currIdx>=nums.length) return 0;
        if(currIdx>=nums.length) return Integer.MIN_VALUE;
        if(dp[currIdx][prevIdx+1]!=-1) return dp[currIdx][prevIdx+1];
        int skip=solve(nums,prevIdx, currIdx+1,dp);
        int take=Integer.MIN_VALUE;
        if(prevIdx==-1 || nums[prevIdx]<nums[currIdx]){
            take=1+solve(nums, currIdx, currIdx+1,dp);
        }
        return dp[currIdx][prevIdx+1]=Math.max(skip, take);
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][nums.length+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return solve(nums, -1, 0,dp);
    }
}