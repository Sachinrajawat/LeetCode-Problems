class Solution {
    public int longestSubarray(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int len=0;
        int count=1;
        System.out.println(max);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==max && nums[i]==nums[i+1]) count++;
            else{
                len=Math.max(len,count);
                count=1;
            }
            System.out.println(count+" "+len);
        }
        len=Math.max(count,len);
        return len;
    }
}