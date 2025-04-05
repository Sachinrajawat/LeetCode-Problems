class Solution {
    
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] count=new int[n];
        Arrays.fill(count,1);
        int maxLen=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    count[i]=count[j];
                    }
                    else if(dp[i]==dp[j]+1)
                    count[i]+=count[j];
                }
            }
            maxLen=Math.max(maxLen,dp[i]);
        }
         int ans=0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) {
                ans += count[i];
            }
        }
        return ans;
    }
}