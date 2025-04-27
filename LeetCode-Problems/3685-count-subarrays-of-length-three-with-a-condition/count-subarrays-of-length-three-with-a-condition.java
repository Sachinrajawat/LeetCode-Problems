class Solution {
    public int countSubarrays(int[] nums) {
        int c=0;
        for(int i=2;i<nums.length;i++){
            double mid=(nums[i-1]/2.0);
            if((nums[i]+nums[i-2])==mid) c++;
        }
        return c;
    }
}