class Solution {
    public int solve(List<List<Integer>> triangle, int row, int col, int[][] dp){
        if(row>=triangle.size()) return 0;
        if(dp[row][col]!=-1) return dp[row][col];
        return dp[row][col]=triangle.get(row).get(col)+Math.min(solve(triangle, row+1, col, dp),solve(triangle, row+1, col+1, dp));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return solve(triangle,0,0, dp);
    }
}