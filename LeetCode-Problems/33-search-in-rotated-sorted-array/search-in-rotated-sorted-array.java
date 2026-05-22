class Solution {
    int find(int[] nums,int st, int end, int target){
        while(st<=end){
            int mid=st+(end-st)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) st=mid+1;
            else end=mid-1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int mid=-1, n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                mid=i;
                break;
            }
        }
        int ans=find(nums,0,mid,target);
        return ans==-1?find(nums,mid+1,n-1,target):ans;
    }
}