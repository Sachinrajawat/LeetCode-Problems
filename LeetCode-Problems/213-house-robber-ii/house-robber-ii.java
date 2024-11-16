class Solution {
    public int find(int n,int[] nums,int index,int[] dp){
        if(index>=n) return 0;
        if(dp[index]!=-1) return dp[index];
        dp[index]=Math.max(nums[index]+find(n,nums,index+2,dp),find(n,nums,index+1,dp));
        return dp[index];
    } 
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp1=new int[n];
        Arrays.fill(dp1,-1);
        int[] dp2=new int[n];
        Arrays.fill(dp2,-1);
        return Math.max(find(n-1,nums,0,dp1),find(n,nums,1,dp2));
    }
}