class Solution {
    public int solve(int amount, int idx,int[] coins, int[][] dp){
        if(amount ==0) return 1;
        if(amount<0 || idx>=coins.length) return 0;
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int notTake=solve(amount, idx+1, coins, dp);
        int take=0;
        if(coins[idx]<=amount){
            take=solve(amount-coins[idx], idx, coins, dp);
        }
        return dp[idx][amount]=notTake+take;
    }
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        return solve(amount,0, coins, dp);
    }
}