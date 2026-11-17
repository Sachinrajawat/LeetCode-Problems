class Solution {
    public int solve(int[] prices, int fee, int idx, int isStock, int[][] dp){
        if(idx>=prices.length) return 0;
        if(dp[idx][isStock]!=-1) return dp[idx][isStock];
        if(isStock==0){
            int buy = -prices[idx]+solve(prices, fee, idx+1, 1 ,dp);
            int notBuy = solve(prices, fee, idx+1, isStock ,dp);
            return dp[idx][isStock]=Math.max(buy, notBuy);
        }
        else{
            int sale=prices[idx]-fee+solve(prices, fee, idx+1, 0,dp);
            int notSale=solve(prices, fee, idx+1, isStock,dp);
            return dp[idx][isStock]=Math.max(sale, notSale);
        }

    }
    public int maxProfit(int[] prices, int fee) {
        int[][] dp=new int[prices.length][2];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        return solve(prices, fee, 0, 0, dp);
    }
}