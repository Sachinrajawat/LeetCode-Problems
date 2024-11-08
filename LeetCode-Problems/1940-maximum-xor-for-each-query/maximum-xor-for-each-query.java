class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int maxPow=(int)Math.pow(2,maximumBit);
        int[] xor=new int[nums.length];
        int xorRes=0;
        for(int i=0;i<nums.length;i++){
            xorRes^=nums[i];
            xor[i]=xorRes;
        }
        int[] ans=new int[nums.length];
        
        for(int i=nums.length-1;i>=0;i--){
            ans[nums.length-1-i]=(maxPow-1)^xor[i];
        }
        return ans;
    }
}