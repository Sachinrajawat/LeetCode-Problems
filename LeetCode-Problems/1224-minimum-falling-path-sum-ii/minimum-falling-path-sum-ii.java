class Solution {
    public int solve(int[][] matrix,int row,int col,int[][] dp){
        if(row==matrix.length) return 0;
        if(col < 0 || col >= matrix.length) return Integer.MAX_VALUE;
        if(dp[row][col]!=Integer.MAX_VALUE) return dp[row][col];
        int ans=Integer.MAX_VALUE;
        if (row == 0){
            for(int j = 0; j < matrix.length; j++){
                ans = Math.min(ans, matrix[row][j] + solve(matrix,row + 1, j,  dp));
            }
            return ans;
        }
        else{ 
            for(int i=0;i<matrix.length;i++){
                if(i==col){
                    continue;
                }
                int res=matrix[row][i]+solve(matrix,row+1,i,dp);
                ans=Math.min(res,ans);
            }
        }
        return dp[row][col]=ans;
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