class Solution {
    public int maxSum(int[] nums){
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        for(int num:nums){
            currSum+=num;
            maxSum=Math.max(maxSum,currSum);
            if(currSum<0) currSum=0;
        }
        return currSum;
    }
    public int minSum(int[] nums){
        int minSum=Integer.MAX_VALUE;
        int currSum=0;
        for(int num:nums){
            currSum+=num;
            minSum=Math.min(minSum,currSum);
            if(currSum>0) currSum=0;
        }
        return currSum;
    }
    public int maxAbsoluteSum(int[] nums) {
        int max=maxSum(nums);
        int min=minSum(nums);
        // System.out.println(max+" "+min);
        return Math.abs(max-min);
    }
}