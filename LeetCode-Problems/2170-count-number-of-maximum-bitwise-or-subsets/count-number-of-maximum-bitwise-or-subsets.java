class Solution {
    public void subsetSum(int target,int[] nums,int idx,int OR,int[] arr){
        if(target==OR) arr[0]++;
        for(int i=idx;i<nums.length;i++){ 
            int newOR=OR|nums[i];
            subsetSum(target,nums,i+1,newOR,arr);
        }
        return;
    }
    public int countMaxOrSubsets(int[] nums) {
        int bitwiseOR=nums[0];
        for(int i=1;i<nums.length;i++){
            bitwiseOR=bitwiseOR | nums[i];
        }
        int[] arr={0};
        subsetSum(bitwiseOR,nums,0,0,arr);
        return arr[0];
    }
}