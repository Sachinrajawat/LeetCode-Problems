class Solution {
    public int binarySearch(int[] nums, int st, int end,int target){
        if(st>end) return -1;
        int mid=st+(end-st)/2;
        if(nums[mid]==target) return mid;
        int ans1=binarySearch(nums,st, mid-1, target);
        int ans2=binarySearch(nums,mid+1, end, target);
        return ans1==-1?ans2:ans1;
    }
    public int search(int[] nums, int target) {
        int rotation=-1;
        int n=nums.length;
        return binarySearch(nums,0, n-1, target);
    }
}