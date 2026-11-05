class Solution {
    public boolean binarySearch(int[] nums, int st, int end,int target){
        if(st>end) return false;
        int mid=st+(end-st)/2;
        if(nums[mid]==target) return true;
        return binarySearch(nums,st, mid-1, target) || binarySearch(nums,mid+1, end, target);
    }
    public boolean search(int[] nums, int target) {
        return binarySearch(nums,0, nums.length-1, target);
    }
}