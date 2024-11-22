class Solution {
    public int solve(int[][] grid, int[][] moveCost,int i,int k,int[][] dp){
        if(i==grid.length-1) return grid[i][k];
        if(dp[i][k]!=-1) return dp[i][k];
        int ans=Integer.MAX_VALUE;

        for(int j=0;j<grid[0].length;j++){
            ans=Math.min(ans,grid[i][k]+ moveCost[grid[i][k]][j]+solve(grid,moveCost,i+1,j,dp));
        }
        return dp[i][k]=ans;
    }
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int ans = Integer.MAX_VALUE;
        int[][] dp=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) Arrays.fill(dp[i],-1);
        for (int j=0;j<grid[0].length;j++) {
            ans = Math.min(ans, solve(grid, moveCost,0,j,dp));
        }
        return ans;
    }
}