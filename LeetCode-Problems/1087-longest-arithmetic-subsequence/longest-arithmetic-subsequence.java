class Solution {
    public int solve(int i,int d,int[] nums,int[][] dp){
        if(i<0) return 0;
        int ans=0;
        if(dp[i][d+501]!=-1) return dp[i][d+501];
        for(int k=i-1;k>=0;k--){ //left side going
            if(nums[i]-nums[k]==d){
                ans=Math.max(ans,1+solve(k,d,nums,dp));
            }
        }
        return dp[i][d+501]=ans;
    }
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;
        int ans=0;
        int[][] dp=new int[1001][1003];
        for(int i=0;i<1001;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int d=nums[j]-nums[i];
                 ans=Math.max(ans,2+solve(i,d,nums,dp));
            }
        }
        return ans;
    }
}