class Solution {
    public int minSwaps(int[] nums) {
        int count1=0;
        for(int num:nums){
            if(num==1) count1++;
        }
        int[] searchArray=new int[nums.length+count1];
        for(int i=0;i<nums.length;i++){
            searchArray[i]=nums[i];
        }
        for(int i=0;i<count1;i++){
            searchArray[nums.length+i]=nums[i];
        }
        int min=Integer.MAX_VALUE;
        int count0=0;
        for(int i=0;i<count1;i++){
            if(searchArray[i]==0) count0++;
        }
        
        min=count0;
        for(int i=count1;i<searchArray.length;i++){
            if(searchArray[i]==0) count0++;
            if(searchArray[i-count1]==0) count0--;
            min=Math.min(min,count0);
        }
        return min;
    }
}