class Solution {
    public int binarySearch(int[] nums, int st, int end){
        if(st>end) return Integer.MAX_VALUE;
        int mid=st+(end-st)/2;
        return Math.min(nums[mid], Math.min(binarySearch(nums, st, mid-1),binarySearch(nums, mid+1, end)));
    }
    public int findMin(int[] nums) {
        return binarySearch(nums, 0, nums.length-1);
    }
}