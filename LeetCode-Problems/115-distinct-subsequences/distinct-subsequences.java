class Solution {
    public int solve(String s, String t,int i,int j,int[][] dp){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int notTake=solve(s,t,i+1,j,dp);
        int take=0;
        if(s.charAt(i)==t.charAt(j)){
            take+=solve(s,t,i+1,j+1,dp);
        }
        return dp[i][j]=take+notTake;
    }
    public int numDistinct(String s, String t) {
        int[][] dp=new int[s.length()][t.length()];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return solve(s,t,0,0,dp);
    }
}