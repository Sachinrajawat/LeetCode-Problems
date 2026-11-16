class Solution {
    public int solve(int[] coins,int idx, int amount, int[][] dp){
        if(amount==0) return 0;
        if(idx>=coins.length) return Integer.MAX_VALUE;
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int notTake=solve(coins, idx+1, amount, dp);
        int take=Integer.MAX_VALUE;
        if(coins[idx]<=amount){
            int res=solve(coins, idx, amount-coins[idx], dp); 
            if(res!=Integer.MAX_VALUE) take=res+1;
        }
        return dp[idx][amount]=Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        int ans=solve(coins, 0, amount, dp);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}