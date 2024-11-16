class Solution {
    
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp1=new int[n+2];
        dp1[n]=0;
        dp1[n-1]=0;
        int[] dp2=new int[n+2];
        dp2[n+1]=0;
        dp2[n]=0;
        for(int i=n-2;i>=0;i--){
            dp1[i]=Math.max(nums[i]+dp1[i+2],dp1[i+1]);
        }
        for(int i=n-1;i>0;i--){
            dp2[i]=Math.max(nums[i]+dp2[i+2],dp2[i+1]);
        }

        return Math.max(dp1[0],dp2[1]);
    }
}