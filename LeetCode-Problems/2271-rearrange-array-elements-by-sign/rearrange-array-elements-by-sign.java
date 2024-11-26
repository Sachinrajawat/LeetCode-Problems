class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] pos=new int[n/2];
        int[] neg=new int[n/2];
        int a=0,b=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                pos[a]=nums[i];
                a++;
            }
            else{
                neg[b]=nums[i];
                b++;
            }
        }
        a=0;
        
        for(int i=0;i<n;i+=2){
            nums[i]=pos[a];
            nums[i+1]=neg[a];
            a++;
        }
        return nums;
    }
}