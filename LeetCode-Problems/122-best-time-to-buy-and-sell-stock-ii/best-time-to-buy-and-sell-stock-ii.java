class Solution {
    public int solve(int[] prices,int idx,int hasStock, int[][] dp){
        if(idx>=prices.length) return 0;
        if(dp[idx][hasStock]!=-1) return dp[idx][hasStock];
        int not=solve(prices,idx+1,hasStock,dp);
        int pick=0;
        if(hasStock==0){
            pick=-prices[idx]+solve(prices,idx+1,1,dp);
        }
        else{
            pick=prices[idx]+solve(prices,idx+1,0,dp);
        }
        return dp[idx][hasStock]=Math.max(not,pick);
    }
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int[] a:dp) Arrays.fill(a,-1);
        return solve(prices,0,0,dp);
    }
}