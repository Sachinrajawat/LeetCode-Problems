class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if(nums.length==1) return 1;
        int ans=1,c=1;
        boolean curr=true;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                if(curr){
                    curr=false;
                    c=1;
                }
                c++;
                ans=Math.max(ans,c);
            }
            else if(nums[i]<nums[i+1]){
                if(!curr){
                    curr=true;
                    c=1;
                }
                c++;
                ans=Math.max(ans,c);
            }
            else{
                c=1;
            }
        }
        return ans;
    }
}