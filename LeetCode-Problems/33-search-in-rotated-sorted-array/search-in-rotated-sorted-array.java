class Solution {
    public int search(int[] nums, int target) {
        int idx=-1, n=nums.length;
        if(n==1) return nums[0]==target?0:-1;
        if(nums[0]==target) return 0;
        if(nums[n-1]==target) return n-1;
        int st=1, end=n-2;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(nums[mid]==target) return mid;
            if(nums[st]<=nums[mid]){
                if(nums[st]<=target && target<nums[mid]){
                    end=mid-1;
                }
                else{
                    st=mid+1;
                }
            }
            else{
                if(nums[mid]<target && target<=nums[end]){
                    st=mid+1;
                }
                else end=mid-1;
            }
        }
        return -1;
    }
}