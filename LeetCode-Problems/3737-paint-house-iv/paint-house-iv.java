class Solution {
    public long solve(int[][] cost,int n,int startSkip,int endSkip,int row,long[][][] dp){
        if(row== n / 2 + 1) return 0;
        if (dp[row][startSkip][endSkip] != -1) return dp[row][startSkip][endSkip];
        long sum=Long.MAX_VALUE;
            for(int j=0;j<3;j++){
                if(j==startSkip) continue;
                for(int k=0;k<3;k++){
                    if(k==j ||  k==endSkip) continue;
                    else sum=Math.min(sum,cost[row-1][j]+cost[n-row][k]+solve(cost,n,j,k,row+1,dp));
                }
            }
        return dp[row][startSkip][endSkip]=sum;
    }
    public long minCost(int n, int[][] cost) {
        long ans=Long.MAX_VALUE;
        long[][][] dp=new long[n/2+1][3][3];
        for (long[][] matrix : dp) {
            for (long[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(j==i) continue;
                else ans=Math.min(ans,cost[0][i]+cost[n-1][j]+solve(cost,n,i,j,2,dp));
            }
        }
        return ans;
    }
}