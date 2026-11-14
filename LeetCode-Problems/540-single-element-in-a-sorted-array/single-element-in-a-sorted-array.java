class Solution {
    public int binarySearch(int[] nums, int st, int end){
        if(st>end) return -1;
        int mid=st+(end-st)/2;
        if(mid-1>=0 && nums[mid]!=nums[mid-1] && mid+1<nums.length && nums[mid]!=nums[mid+1]) return nums[mid];
        if(mid-1<0 && mid+1<nums.length && nums[mid]!=nums[mid+1]) return nums[mid];
        if(mid+1>=nums.length && mid-1>=0 && nums[mid]!=nums[mid-1]) return nums[mid];
        int ans1=binarySearch(nums,st, mid-1);
        int ans2=binarySearch(nums, mid+1, end);
        return ans1==-1?ans2:ans1;
    }
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        return binarySearch(nums, 0, nums.length-1);
    }
}