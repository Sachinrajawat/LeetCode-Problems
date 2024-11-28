class Solution {
    public int solve(String text1, String text2,int i,int j,int[][] dp){
        if(i==0) return j;
        else if(j==0) return i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i-1)==text2.charAt(j-1)) return dp[i][j]=solve(text1,text2,i-1,j-1,dp);
        else{
        int insert=1+solve(text1,text2,i,j-1,dp);
        int delete=1+solve(text1,text2,i-1,j,dp);
        int replace=1+solve(text1,text2,i-1,j-1,dp);
        int ans=Math.min(insert,delete);
        return dp[i][j]=Math.min(ans,replace);
       }
    }

    public int minDistance(String text1, String text2) {
        int n=text1.length(),m=text2.length();
        if(n==0 || m==0) return Math.max(m,n);
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        solve(text1,text2,n,m,dp);
        return dp[n][m];
    }
}