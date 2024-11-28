class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] LIS=new int[n+1];
        int size=0;
        LIS[0]=nums[0];
        for(int i=1;i<n;i++){
            int start=0,end=size;
            int idx=size+1;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(LIS[mid]<nums[i]){
                    start=mid+1;
                }
                else if(LIS[mid]==nums[i]){
                    idx=mid;
                    break;
                }
                else{
                    end=mid-1;
                    idx=mid;
                }
            }
            LIS[idx]=nums[i];
            size=Math.max(size,idx);
        }
        return size+1;
    }
}