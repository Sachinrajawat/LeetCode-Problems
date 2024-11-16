class Solution {
    public int find(int index,int[] nums,int n,int[] dp){
        if(index>=n) return 0;
        if(dp[index]!=-1) return dp[index];
        dp[index]=Math.max(nums[index]+ find(index+2,nums,n,dp),find(index+1,nums,n,dp));
        return dp[index];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return find(0,nums,n,dp);
    }
}