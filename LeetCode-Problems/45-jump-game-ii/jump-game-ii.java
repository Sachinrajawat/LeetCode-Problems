class Solution {
    public int solve(int[] nums, int idx, int[] dp){
        if(idx>=nums.length) return Integer.MAX_VALUE;
        if(idx==nums.length-1) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int min=Integer.MAX_VALUE;
        for(int i=idx+1;i<=(idx+nums[idx]) && i<nums.length ;i++){
            int jump=solve(nums,i, dp);
            if(jump!=Integer.MAX_VALUE){
                min=Math.min(min, 1+jump);
            }
        }
        return dp[idx]=min;
    }
    public int jump(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return solve(nums,0, dp);
    }
}