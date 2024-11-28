class Solution {
    public int solve(int[] nums,int sum,int idx,int[][] dp){
        if(sum==0) return 1;
        if(idx==0) return 0;
        if(dp[idx][sum]!=-1) return dp[idx][sum];
        if(nums[idx-1]>sum) return dp[idx][sum]=solve(nums,sum,idx-1,dp);
        else return dp[idx][sum]=solve(nums,sum-nums[idx-1],idx-1,dp) ==1||solve(nums,sum,idx-1,dp)==1?1:0;
    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        sum/=2;
        int[][] dp=new int[n+1][sum+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(nums,sum,n,dp)==1;
    }
}