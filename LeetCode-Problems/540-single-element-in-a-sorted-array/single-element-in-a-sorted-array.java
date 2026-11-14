class Solution {
    public int binarySearch(int[] nums, int st, int end){
        if(st>end) return -1;
        int mid=st+(end-st)/2;
        boolean diffLeft = (mid == 0 || nums[mid] != nums[mid - 1]);
        boolean diffRight = (mid == nums.length - 1 || nums[mid] != nums[mid + 1]);

        if (diffLeft && diffRight) return nums[mid];
        int ans1=binarySearch(nums,st, mid-1);
        return ans1!=-1?ans1:binarySearch(nums, mid+1, end);
    }
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        return binarySearch(nums, 0, nums.length-1);
    }
}