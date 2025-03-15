class Solution {
    public boolean isPossible(int[] nums,int target,int k){
        int house=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=target){
                house++;
                i++;
            }
        }
        return house>=k;
    }
    public int minCapability(int[] nums, int k) {
        int l=Integer.MAX_VALUE,r=0;
        for(int i=0;i<nums.length;i++){
            l=Math.min(l,nums[i]);
            r=Math.max(r,nums[i]);
        }
        int res=r;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isPossible(nums,mid,k)){
                res=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return res;
    }
}