class Solution {
    public int find(int n,int[] dp){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        dp[n]=find(n-1,dp)+find(n-2,dp);
        return dp[n];
    }
    public int fib(int n) {
        if(n==0) return 0;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        return find(n,dp);
    }
}