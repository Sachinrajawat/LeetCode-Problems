class Solution {
    public int solve(int[] cost, int idx,int[] dp){
        if(idx>=cost.length-1) return 0;
        if(dp[idx]!=-1) return dp[idx];
        return dp[idx]=Math.min(cost[idx]+solve(cost,idx+1,dp),cost[idx+1]+solve(cost,idx+2,dp));
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length+1];
        Arrays.fill(dp,-1);
        return solve(cost,0,dp);
    }
}