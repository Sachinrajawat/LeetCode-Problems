class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        if(n<3) return false;
        int[] prefMin=new int[n-2];
        int min=nums[0];
        for(int i=1;i<n-1;i++){
            min=Math.min(min,nums[i]);
            prefMin[i-1]=min;
        }
        int max=nums[n-1];
        int[] sufMax=new int[n-2];
        for(int i=n-1;i>1;i--){
            max=Math.max(max,nums[i]);
            sufMax[i-2]=max;
        }
        for(int j=1;j<n-1;j++){
            // System.out.println(prefMin[j-1]+" "+nums[j]+" "+sufMax[j-1]);
            boolean left=false, right=false;
            if(prefMin[j-1]<nums[j]) left=true;
            if(sufMax[j-1]>nums[j]) right=true;
            if(left&&right) return true;
        }
        return false;
    }
}