class Solution {
    public int solve(int[] prices,int idx,boolean hasStock, int count,int[][][] dp){
        if(count==0 || idx>=prices.length) return 0;
        int x=hasStock==true?1:0;
        if(dp[idx][x][count]!=-1) return dp[idx][x][count];
        int skip=solve(prices,idx+1,hasStock,count,dp);
        int take=0;
        if(!hasStock){
            take=-prices[idx]+solve(prices,idx+1,true,count,dp);
        }
        else{
            take=+prices[idx]+solve(prices,idx+1,false,count-1,dp);
        }
        return dp[idx][x][count]=Math.max(skip,take);
    }
    public int maxProfit(int k, int[] prices) {
        int[][][] dp=new int[prices.length][2][k+1];
        for(int[][] arr:dp){
            for(int[] array:arr){
                Arrays.fill(array,-1);
            }
        }
        return solve(prices,0,false,k,dp);
    }
}