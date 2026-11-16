class Solution {
    public int solve(int[][] matrix, int i, int j, int[][] dp){
        if(i>=matrix.length || j>=matrix[0].length || matrix[i][j]==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int right=solve(matrix, i, j+1,dp);
        int bottom=solve(matrix, i+1, j,dp);
        int diag=solve(matrix, i+1, j+1,dp);
        int min=1+Math.min(right, Math.min(bottom, diag));
        return dp[i][j]=min;
    }
    public int countSquares(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int ans=0;
        int[][] dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    ans+=solve(matrix, i, j,dp);
                }
            }
        }
        return ans;
    }
}