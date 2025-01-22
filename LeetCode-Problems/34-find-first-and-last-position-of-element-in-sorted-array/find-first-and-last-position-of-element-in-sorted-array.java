class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start=0,end=nums.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]<target) start=mid+1;

            else if(nums[mid]>target) end=mid-1;

            else{
                ans=mid;
                end=mid-1;
            }
        }
        if(ans==-1) return new int[]{-1,-1};
        start=ans;
        end=nums.length-1;
        int sec=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]<target) start=mid+1;
            
            else if(nums[mid]>target) end=mid-1;

            else{
                sec=mid;
                start=mid+1;
            }
        }
        return new int[]{ans,sec};
    }
}