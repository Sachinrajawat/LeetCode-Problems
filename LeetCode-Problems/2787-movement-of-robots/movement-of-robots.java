class Solution {
    int MOD=1000000007;
    public int sumDistance(int[] num, String s, int d) {
        long[] nums=new long[num.length];
        for(int i=0;i<num.length;i++){
            nums[i]=num[i];
        }
        long ans=0;
        for(int i=0;i<nums.length;i++){
            if(s.charAt(i)=='R') nums[i]+=d;
            else nums[i]-=d;
        }
        Arrays.sort(nums);
        long[] prefixSum=new long[nums.length];
        prefixSum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefixSum[i]=(nums[i]+prefixSum[i-1]);
        }
        
        for(int i=1;i<prefixSum.length;i++){
            long y=((long)nums[i]*i-prefixSum[i-1])%MOD;
            // y=(y+MOD)%MOD;
            ans=(y+ans)%MOD;
        }
        return (int)ans;
    }
}