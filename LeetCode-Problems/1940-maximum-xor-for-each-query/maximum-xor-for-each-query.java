class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n=nums.length;
        int maxPow=(int)Math.pow(2,maximumBit);
        int[] xor=new int[n];
        xor[0]=nums[0];
        for(int i=1;i<n;i++){
            xor[i]=xor[i-1]^nums[i];
        }
        int[] ans=new int[n];
        
        for(int i=n-1;i>=0;i--){
            ans[n-1-i]=(maxPow-1)^xor[i];
        }
        return ans;
    }
}