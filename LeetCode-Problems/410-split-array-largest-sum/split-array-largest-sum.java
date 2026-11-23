class Solution {
    public int solve(int[] nums, int idx, int k, int n, int[][] dp){
        if(k==1) return idx==0?nums[n-1]:nums[n-1]-nums[idx-1];
        int ans=Integer.MAX_VALUE;
        if(dp[idx][k]!=-1) return dp[idx][k];
        for(int i=idx;i<=n-k;i++){
            if(idx==0) ans=Math.min(ans, Math.max(nums[i], solve(nums, i+1, k-1, n, dp)));
            else{
                ans=Math.min(ans, Math.max(nums[i]-nums[idx-1], solve(nums, i+1, k-1, n, dp)));
            }
            // System.out.println(i+" "+k+" "+ans);
        }
        return dp[idx][k]=ans;
    }
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        for(int i=1;i<nums.length;i++) nums[i]+=nums[i-1];
        if(k==1) return nums[n-1];
        int[][] dp=new int[n][k+1];
        for(int[] row:dp) Arrays.fill(row, -1);
        return solve(nums, 0, k, n, dp);
    }
}