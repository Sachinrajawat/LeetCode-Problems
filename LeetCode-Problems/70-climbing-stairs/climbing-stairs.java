class Solution {
    public int recr(int n,int[] dp,int i){
        if(i==n) return 1;
        if(i>n) return 0;
        if(dp[i]!=-1) return dp[i];
        dp[i]= recr(n,dp,i+1)+recr(n,dp,i+2);
        return dp[i];
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+2];
        Arrays.fill(dp,-1);
        dp[n+1]=0;
        dp[n]=1;
        return recr(n,dp,0);
    }
}