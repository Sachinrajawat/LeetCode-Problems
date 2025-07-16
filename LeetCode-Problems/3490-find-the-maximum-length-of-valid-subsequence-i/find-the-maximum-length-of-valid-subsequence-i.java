class Solution {
    public int maximumLength(int[] nums) {
        int cEven=0, cOdd=0, cAlternating=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                cEven++;
            }
            else{
                cOdd++;
            }
        }
        int parity=nums[0]%2;
        for(int i=1;i<nums.length;i++){
            int currParity=nums[i]%2;
            if(currParity!=parity){
                cAlternating++;
                parity=nums[i]%2;
            }
        }
        return Math.max(Math.max(cEven,cOdd),cAlternating);
    }
}