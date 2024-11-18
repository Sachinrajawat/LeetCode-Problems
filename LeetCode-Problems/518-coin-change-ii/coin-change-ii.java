class Solution {
    public int recursion(int amount,int[] coins,int idx,int[][] dp){
        if(amount<0 || idx>=coins.length) return 0;
        if(amount==0) return 1;
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        dp[idx][amount]= recursion(amount-coins[idx],coins,idx,dp)+recursion(amount,coins,idx+1,dp);
        return dp[idx][amount];
    }
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length+1][amount+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return  recursion(amount,coins,0,dp);
    }
}