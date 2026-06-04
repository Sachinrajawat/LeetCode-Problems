class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int count=1;
        for(int i=1;i<n;i++){
            if(nums[i-1]==nums[i]) count++;
            else{
                if(count>(n/2)) return nums[i-1];
                else{
                    count=1;
                }
            }
        }
        return nums[n-1];
    }
}