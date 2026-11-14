class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int ans=Integer.MAX_VALUE;
        int st=1, end=-1;
        for(int num:nums){
            end=Math.max(end, num);
        }
        while(st<=end){
            int mid=st+(end-st)/2;
            int sum=0;
            for(int i=0;i<nums.length;i++){
                sum+=(nums[i]+mid-1)/mid;
            }
            if(sum<=threshold){
                ans=Math.min(ans, mid);
                end=mid-1;
            }else st=mid+1;
        }
        return ans;
    }
}