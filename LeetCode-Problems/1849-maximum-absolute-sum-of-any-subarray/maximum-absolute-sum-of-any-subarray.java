class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int num:nums){
            sum+=num;
            if(sum<0) sum=0;
            max=Math.max(max, sum);
        }
        int min=Integer.MAX_VALUE;
        sum=0;
        for(int num:nums){
            sum+=num;
            if(sum>0) sum=0;
            min=Math.min(min, sum);
        }
        return Math.max(Math.abs(max), Math.abs(min));
    }
}