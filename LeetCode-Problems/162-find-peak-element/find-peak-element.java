class Solution {
    public int findPeakElement(int[] nums) {
        int ans=-1;
        
        int start=0,end=nums.length-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            if(nums[mid] < nums[mid+1]){  //uphill
                start = mid+1;
            }
            else{ 
                end=mid-1;
            }
        }
        return -1;
    }
}