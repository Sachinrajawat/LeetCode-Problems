class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long count=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            int start=i+1,end=nums.length-1;
            int target=lower-nums[i];
            int ans1=-1,ans2=-1;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(nums[mid]>=target){
                    ans1=mid;
                    end=mid-1;
                }
                else start=mid+1;
            }
            target=upper-nums[i];
            start=i+1;
            end=nums.length-1;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(nums[mid]<=target){
                    ans2=mid;
                    start=mid+1;
                }
                else end=mid-1;
            }
            if (ans1 != -1 && ans2 != -1 && ans2 >= ans1) {
                count += (ans2 - ans1 + 1);
            }
        }
        return count;
    }
}