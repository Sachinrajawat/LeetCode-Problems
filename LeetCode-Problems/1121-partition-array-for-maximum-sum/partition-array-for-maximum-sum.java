class Solution {
    public int solve(int[] arr,int k,int idx,int[] dp){
        if(idx>=arr.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int res=0;
        int ans=0;
        for(int i=idx;i<arr.length && i<idx+k ;i++){
            ans=Math.max(ans,arr[i]);
            res=Math.max(res,ans*(i-idx+1)+solve(arr,k,i+1,dp));
        }
        return dp[idx]=res;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length];
        Arrays.fill(dp,-1);
        return solve(arr,k,0,dp);
    }
}