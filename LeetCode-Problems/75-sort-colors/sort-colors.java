class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int countZero=0, countOne=0, countTwo=0;
        for(int i=0;i<n;i++){
           if(nums[i]==0) countZero++;
           else if(nums[i]==1) countOne++;
           else countTwo++;
        }
        int i=0;
        for(int j=0;j<countZero;j++){
            nums[i]=0;
            i++;
        }
         for(int j=0;j<countOne;j++){
            nums[i]=1;
            i++;
        }
         for(int j=0;j<countTwo;j++){
            nums[i]=2;
            i++;
        }
    }
}