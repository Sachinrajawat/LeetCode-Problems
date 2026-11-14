class Solution {
    
    public int maxProduct(int[] nums) {
        int maxProduct=Integer.MIN_VALUE;
        int pre=1, suff=1;
        for(int i=0;i<nums.length;i++){
            if(pre==0) pre=1;
            if(suff==0) suff=1;
            pre*=nums[i];
            suff*=nums[nums.length-i-1];
            maxProduct=Math.max(maxProduct, pre);
            maxProduct=Math.max(maxProduct, suff);
        }
        return maxProduct;
    }
}