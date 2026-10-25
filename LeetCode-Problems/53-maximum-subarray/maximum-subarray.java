class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int num:nums){
            sum+=num;
            max=Math.max(max, sum);
            if(sum<0) sum=0;
        }
        // -2,1,-3,4,-1,2,1,-5,4
        // -2,-1,-4,0,-1 
        // -1
        return max;
    }
}