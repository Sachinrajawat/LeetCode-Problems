class Solution {
    public int solve(String text1,String text2,int i,int j,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
             return dp[i][j]= 1+solve(text1,text2,i-1,j-1,dp);
        }
        else{
            return dp[i][j]= Math.max(solve(text1,text2,i-1,j,dp),solve(text1,text2,i,j-1,dp));
        }
    }

    public int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        int n=s.length();
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(s,sb.toString(),n-1,n-1,dp);
    }
}