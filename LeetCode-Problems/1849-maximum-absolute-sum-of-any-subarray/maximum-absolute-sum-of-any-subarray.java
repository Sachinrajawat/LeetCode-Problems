class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        int maxSum=0, minSum=0;
        for(int num:nums){
            maxSum+=num;
            minSum+=num;
            if(maxSum<0) maxSum=0;
            if(minSum>0) minSum=0;
            max=Math.max(max, maxSum);
            min=Math.min(min, minSum);
        }
        return Math.max(Math.abs(max), Math.abs(min));
    }
}