class Solution {
    public int solve(int[][] grid,int m,int n,int[][] dp){
        if(m<0 || n<0) return 100000;
        if(dp[m][n]!=-1) return dp[m][n];
        if(m==0 && n==0){
            return dp[m][n]=grid[0][0];
        }
        int up=grid[m][n]+solve(grid,m-1,n,dp);
        int left=grid[m][n]+solve(grid,m,n-1,dp);
        return dp[m][n]=Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        solve(grid,m-1,n-1,dp);
        return dp[m-1][n-1];
    }
}