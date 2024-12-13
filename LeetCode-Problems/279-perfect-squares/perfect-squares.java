class Solution {
    public int solve(ArrayList<Integer> sq,int n,int idx,int[][] dp){
        
        if(n==0) return 0;
        if(idx<0 || n<0) return Integer.MAX_VALUE;
        if(dp[n][idx]!=-1) return dp[n][idx];
        int include=solve(sq,n-sq.get(idx),idx,dp);
        if (include!=Integer.MAX_VALUE) include+=1;

        int exclude=solve(sq,n,idx-1,dp);

        dp[n][idx]=Math.min(include, exclude);
        return dp[n][idx];
    }
    public int numSquares(int n) {
        ArrayList<Integer> sq=new ArrayList<>();
        int i=1;
        while (i * i <= n) { 
            sq.add(i * i);
            i++;
        }
        int[][] dp=new int[n+1][sq.size()];
        for(int j=0;j<=n;j++){
            Arrays.fill(dp[j],-1);
        }
        return solve(sq,n,sq.size()-1,dp);
    }
}