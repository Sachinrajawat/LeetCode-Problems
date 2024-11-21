class Solution {
    
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;
        int ans=0;
        int[][] dp=new int[n][1003];
       
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int d=nums[i]-nums[j]+501;
                dp[i][d]=dp[j][d]>0?1+dp[j][d]:2;
                ans=Math.max(ans,dp[i][d]);
            }
        }
        return ans;
    }
}