class Solution {
    public long countSubarrays(int[] nums, int k) {
        long count=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
        }
        int j=0, l=0, cntMax=0;
        int[] countMax=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max) cntMax++;
            countMax[i]=cntMax;
        }
        while(j<nums.length){
            if(countMax[j]>=k){
                while(l<=j){
                    if((countMax[j]-countMax[l])==(k-1)){
                        count+=l+1;
                        break;
                    }
                    l++;
                }
            }
            j++;
        }
    return count;
    }
}