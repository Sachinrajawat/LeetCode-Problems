class Solution {
    public int pivotIndex(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        for(int i=0;i<nums.length;i++) System.out.print(nums[i]+" ");
        for(int i=0;i<nums.length;i++){
            if(nums[nums.length-1]-nums[i]==(i==0?0:nums[i-1])) return i;
        }
        return -1;
    }
}