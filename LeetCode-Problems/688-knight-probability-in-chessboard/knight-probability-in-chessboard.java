class Solution {
    int N;
    public double solve(int r,int c,int k,double[][][] dp){
        if(r<0 || r>=N || c<0 || c>=N){
            return 0;
        }
        if(dp[r][c][k]!=-1) return dp[r][c][k];
        if(k==0){
            return 1;
        }
        double ans=0;
        int[] row={-1,-1,-2,-2,1,1,2,2};
        int[] col={-2,2,-1,1,-2,2,-1,1};
        for(int i=0;i<8;i++){
            int new_r=r+row[i];
            int new_c=c+col[i];
            ans+=solve(new_r,new_c,k-1,dp);
        }
        return dp[r][c][k]=ans/(8.0);
    }
    public double knightProbability(int n, int k, int row, int column) {
        N=n;
        double[][][] dp=new double[n][n][k+1];
         for (double[][] grid : dp)
            for (double[] subgrid : grid)
                Arrays.fill(subgrid, -1);

        return solve(row,column,k,dp);   
    }
}