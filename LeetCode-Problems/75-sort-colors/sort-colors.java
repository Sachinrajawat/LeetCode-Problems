class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                int st=i,end=i+1;
                while(st>=0 && nums[st]>nums[end]){
                    int temp=nums[st];
                    nums[st]=nums[end];
                    nums[end]=temp;
                    st--;
                    end--;
                }
            }
        }
    }
}