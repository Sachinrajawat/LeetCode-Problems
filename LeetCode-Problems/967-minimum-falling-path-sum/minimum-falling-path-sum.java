class Solution {
    public int solve(int[][] matrix,int row,int col,int[][] dp){
        if(row==matrix.length) return 0;
        if(col==matrix.length || col<0) return Integer.MAX_VALUE;
        if(dp[row][col]!=Integer.MAX_VALUE) return dp[row][col];
        int a=solve(matrix,row+1,col+1,dp);
        int b=solve(matrix,row+1,col,dp);
        int c=solve(matrix,row+1,col-1,dp);
        return dp[row][col]=matrix[row][col]+Math.min(c,Math.min(a,b));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int ans=Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            ans=Math.min(ans,solve(matrix,0,i,dp));
        }
        return ans;
    }
}