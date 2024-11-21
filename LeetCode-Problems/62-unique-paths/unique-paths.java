// class Solution {
    // public int path(int m,int n,int i,int j,int[][] dp){
    //     if(i==m || j==n) return 0;
    //     if(i==m-1 || j==n-1) return 1;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     return dp[i][j]=path(m,n,i+1,j,dp)+path(m,n,i,j+1,dp);
    // }
//     public int uniquePaths(int m, int n) {
//         int[][] dp=new int[m+1][n+1];
//         for(int i=0;i<m;i++){
//             dp[i][0]=1;
//         }
//         for(int i=0;i<n;i++){
//             dp[0][i]=1;
//         }
//         for(int i=1;i<m+1;i++){
//             for(int j=1;j<n+1;j++){
//                 dp[i][j]=dp[i+1][j]+dp[i][j+1];
//             }
//         }
//         return dp[m][n];
//     }
// }

class Solution {
    public int path(int m,int n,int[][] dp){
        if(m<0 || n<0) return 0;
        if(m==0|| n==0) return 1;
        if(dp[m][n]!=-1) return dp[m][n];
        return dp[m][n]=path(m-1,n,dp)+path(m,n-1,dp);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return path(m-1,n-1,dp);
    }
}