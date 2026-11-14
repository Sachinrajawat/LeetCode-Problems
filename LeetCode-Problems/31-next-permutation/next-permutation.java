class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int gola_index=-1;
        for(int i=n-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                gola_index=i-1;
                break;
            }
        }

        if(gola_index!=-1){
            int swap_index=gola_index;
            for(int j=n-1;j>=gola_index+1;j--){
                if(nums[j]>nums[gola_index]){
                    int temp=nums[gola_index];
                    nums[gola_index]=nums[j];
                    nums[j]=temp;
                    break;
                }
            }
        }
        int st=gola_index+1, end=n-1;
        while(st<=end){
            int temp1=nums[st];
            nums[st]=nums[end];
            nums[end]=temp1;
            st++;
            end--;
        }
    }
}