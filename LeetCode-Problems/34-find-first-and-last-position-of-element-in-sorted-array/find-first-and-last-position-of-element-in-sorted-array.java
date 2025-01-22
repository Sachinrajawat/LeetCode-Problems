class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start=0,end=nums.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]<target){
                start=mid+1;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
            else{
                ans=mid;
                end=mid-1;
            }
        }
        
        if(ans==-1) return new int[]{-1,-1};
        int sec=ans;
        for(int i=ans+1;i<nums.length;i++){
            if(nums[i]==target) sec++;
            else break;
        }
        return new int[]{ans,sec};
    }
}