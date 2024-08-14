class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n=nums.length,ans=0;
        Arrays.sort(nums);
        int start=0,end=nums[n-1]-nums[0];
        while(start<=end){
            int mid=start+(end-start)/2;
            int count=0;
            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    int a=Math.abs(nums[i]-nums[j]);
                    if(a<=mid) count++;
                    else break;
                }
            }
            if(count>=k){
                ans=mid;
                end=mid-1;
            }
            else start=mid+1;
        }
        return ans;
    }

}