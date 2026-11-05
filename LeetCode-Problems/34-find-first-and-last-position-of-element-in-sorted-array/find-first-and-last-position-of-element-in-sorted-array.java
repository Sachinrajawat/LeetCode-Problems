class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr={-1,-1};
        int n=nums.length;
        int st=0, end=nums.length-1;
        int ans=-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(nums[mid]==target){
                ans=mid;
                end=mid-1;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        if(ans==-1) return arr;
        st=ans;
        end=n-1;
        arr[0]=ans;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(nums[mid]==target){
                ans=mid;
                st=mid+1;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        arr[1]=ans;
        return arr;
    }
}