class Solution {
    public int solve(int[][] grid, int i, int j, int x, int[][][] dp){
        int n=grid.length;
        int m=grid[0].length;
        if (i >= n || j < 0 || j >= m || x < 0 || x >= m) return 0;
        if(dp[i][j][x] !=-1) return dp[i][j][x];
        int cherries=grid[i][j];
        if (j!=x) cherries+=grid[i][x];
        int max=0;
        for(int val1=-1;val1<=1;val1++){
            for(int val2=-1;val2<=1;val2++){
                int nrow1=i+1;
                int ncol1=j+val1;
                int ncol2=x+val2;
                max=Math.max(max,solve(grid,nrow1,ncol1, ncol2, dp));
            }
        }
        return dp[i][j][x]=max+cherries;
    }
    public int cherryPickup(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        int[][][] dp=new int[n][m][m];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        return solve(grid,0,0,grid[0].length-1, dp);
    }
}