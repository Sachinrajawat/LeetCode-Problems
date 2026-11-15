class Solution {
    public int solve(int[][] matrix, int i, int j, int[][] dp){
        if(i<0 || j<0 || j>=matrix[0].length) return Integer.MAX_VALUE/2;
        if(i==0) return matrix[i][j];
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        
        int up=matrix[i][j]+solve(matrix, i-1, j, dp);
        int left=matrix[i][j]+solve(matrix, i-1, j-1, dp);
        int right=matrix[i][j]+solve(matrix, i-1, j+1, dp);
        return dp[i][j]=Math.min(up, Math.min(left, right));
    }
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int min=Integer.MAX_VALUE;
        int[][] dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            min=Math.min(min, solve(matrix, m-1, i, dp));
        }
        return min;
    }
}