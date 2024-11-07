class Solution {
    public boolean canSortArray(int[] nums) {
        if(nums.length==1) return true;
        
        for(int i=nums.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(nums[j]>nums[j+1]){
                    if(Integer.bitCount(nums[j])!=Integer.bitCount(nums[j+1])) return false;
                    else{
                        int temp=nums[j];
                        nums[j]=nums[j+1];
                        nums[j+1]=temp;
                    }
                }
            }
        }
        return true;
    }
}