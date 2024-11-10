class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int min=Integer.MAX_VALUE;
        int i=0;
        while(i<nums.length){
            int x=nums[i];
            for(int j=i;j<nums.length;j++){
                x|=nums[j];
                if(x>=k){
                    min=Math.min(min,j-i+1);
                    break;
                }
            }
            i++;
        }
        return min==2147483647?-1:min;
    }
}