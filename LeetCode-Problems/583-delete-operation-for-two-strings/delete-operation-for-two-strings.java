class Solution {
    public int solve(String text1,String text2,int i,int j,int[][] dp){
        if(i<=0 || j<=0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i-1)==text2.charAt(j-1)){
             return dp[i][j]=1+solve(text1,text2,i-1,j-1,dp);
        }
        else{
            return dp[i][j]=Math.max(solve(text1,text2,i-1,j,dp),solve(text1,text2,i,j-1,dp));
        }
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length(),m=word2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        int len=solve(word1,word2,n,m,dp);
        return n+m-2*len;   
    }
}