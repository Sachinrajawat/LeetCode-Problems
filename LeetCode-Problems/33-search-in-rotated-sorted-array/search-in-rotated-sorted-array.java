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
        // if(nums.length==1 && nums[0]==target) return 0;
        // if(nums.length==1 && nums[0]!=target) return -1;
        int mid=-1, n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                mid=i;
                break;
            }
        }
        int ans=find(nums,0,mid,target);
        if(ans==-1){
            ans=find(nums,mid+1,n-1,target);
        }
        return ans;
    }
}