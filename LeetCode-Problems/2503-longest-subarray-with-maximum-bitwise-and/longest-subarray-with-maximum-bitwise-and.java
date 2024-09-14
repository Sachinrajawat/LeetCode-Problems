class Solution {
    public int longestSubarray(int[] nums) {
        int max=0, len=0,count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                count=1;
                len=1;
                max=nums[i];
            }
            else if(nums[i]==max){
                count++;
                len=Math.max(len,count);
            }
            else count=0;
        }
        return len;
    }
}