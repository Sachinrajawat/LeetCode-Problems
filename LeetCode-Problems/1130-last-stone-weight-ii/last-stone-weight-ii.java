class Solution {
    private int x;
    public int solve(int[] stones, int idx, int sum,int[][] dp){
        if(idx>= stones.length && sum<0) return Integer.MAX_VALUE;
        if(idx>=stones.length) return sum;
        if(dp[idx][sum+x]!=-1) return dp[idx][sum+x];
        int take=solve(stones,idx+1,sum+stones[idx],dp);
        int notTake=solve(stones,idx+1,sum-stones[idx],dp);
        return dp[idx][sum+x]=Math.min(take, notTake);
    }
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int stone:stones) sum+=stone;
        int[][] dp=new int[stones.length][2*sum+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        this.x=sum;
        return solve(stones, 0, 0,dp);
    }
}