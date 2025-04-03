class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        long ans=Long.MIN_VALUE;
        long[] pre=new long[n-2];
        long max=0;
        for(int i=0;i<n-2;i++){
            max=(long)Math.max(max,nums[i]);
            pre[i]=max;
        }
        max=0;
        long[] suf=new long[n-2];
        for(int i=n-1;i>1;i--){
            max=(long)Math.max(max,nums[i]);
            suf[i-2]=max;
        }
        for(int i=1;i<n-1;i++){
            ans=Math.max(ans,(long)((pre[i-1]-nums[i])*suf[i-1]));
        }
        
        return Math.max(0,ans);
    }
}