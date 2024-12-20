class Solution {
    public int solve(int[] prices,int idx,int buy,int[][] dp){
        if(idx>=prices.length) return 0;
        // System.out.println(idx);
        if(dp[idx][buy+1]!=-1) return dp[idx][buy+1];
        if(buy>=0){
            if(prices[idx]>buy){
                return dp[idx][buy+1]=Math.max(prices[idx]-buy+solve(prices,idx+2,-1,dp),solve(prices,idx+1,buy,dp));
            }
            else return dp[idx][buy+1]=solve(prices,idx+1,buy,dp);
        }
        else{
            return dp[idx][buy+1]= Math.max(solve(prices,idx+1,prices[idx],dp),solve(prices,idx+1,buy,dp));
        }
    }
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][5000];
        for(int i=0;i<prices.length;i++) Arrays.fill(dp[i],-1);
        return solve(prices,0,-1,dp);
    }
}