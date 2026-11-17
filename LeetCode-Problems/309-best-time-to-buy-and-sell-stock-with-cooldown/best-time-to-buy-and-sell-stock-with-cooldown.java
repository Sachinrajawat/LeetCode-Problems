class Solution {
    public int solve(int[] prices, int idx, int isStock, int[][] dp){
        if(idx>=prices.length) return 0;
        if(dp[idx][isStock]!=-1) return dp[idx][isStock];
        if(isStock==0){
            int buy=-prices[idx]+solve(prices, idx+1, 1, dp);
            int notBuy=solve(prices, idx+1, isStock, dp);
            return dp[idx][isStock]=Math.max(buy, notBuy);
        }
        else{
            int sell=prices[idx]+solve(prices, idx+2, 0,dp);
            int notSell=solve(prices, idx+1, isStock,dp);
            return dp[idx][isStock]=Math.max(sell, notSell);
        }
    }
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int[] row:dp) Arrays.fill(row, -1);
        return solve(prices, 0, 0, dp);
    }
}