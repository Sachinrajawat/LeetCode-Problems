class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length-k+1;
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            int j;
            for(j=i;j<i+k-1;j++){
                if(nums[j+1]-nums[j]!=1){
                    result[i]=-1;
                    break;
                }
            }
            if(j==i+k-1) result[i]=nums[i+k-1];
        }

        return result;
    }
}