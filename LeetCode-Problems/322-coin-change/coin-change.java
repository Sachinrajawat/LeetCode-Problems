class Solution {
    public int solve(int[] coins,int amount,int idx,int[][] dp){
        if(amount==0) return 0;
        if(idx<0) return Integer.MAX_VALUE;
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int skip=solve(coins,amount,idx-1, dp);
        int pick=Integer.MAX_VALUE;
        if(coins[idx]<=amount){
            int res=solve(coins,amount-coins[idx],idx, dp);
            if(res!=Integer.MAX_VALUE) pick=res+1;
        }
        return dp[idx][amount]=Math.min(pick,skip);
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length+1][amount+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        int ans=solve(coins,amount,coins.length-1,dp);
        return ans==2147483647?-1:ans;
    }
}