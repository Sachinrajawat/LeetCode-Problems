class Solution {
    public int solve(int[] jobDifficulty, int d,int idx,int[][] dp){
        if(dp[d][idx]!=-1) return dp[d][idx];
        if(d==1){
            int maxDiff=0;
            for (int i=idx;i>=0;i--) {
                maxDiff=Math.max(maxDiff,jobDifficulty[i]);
            }
            return dp[d][idx]=maxDiff;
        }
        int maxDiff = 0;
        int minOverallDifficulty = Integer.MAX_VALUE;
        for(int i=idx;i>=d-1;i--){
            maxDiff = Math.max(maxDiff, jobDifficulty[i]);
            int curr=maxDiff+solve(jobDifficulty,d-1,i-1,dp);
            minOverallDifficulty=Math.min(minOverallDifficulty,curr);
            }
        return dp[d][idx]=minOverallDifficulty;
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n=jobDifficulty.length;
        if(n<d) return -1;
        int[][] dp=new int[d+1][n];
        for(int i=0;i<=d;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(jobDifficulty,d,n-1,dp);
    }
}