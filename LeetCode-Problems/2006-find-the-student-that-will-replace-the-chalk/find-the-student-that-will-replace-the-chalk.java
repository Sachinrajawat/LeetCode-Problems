class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n=chalk.length;
        long[] prefixSum=new long[n];
        prefixSum[0]=chalk[0];
        for(int i=1;i<n;i++) prefixSum[i]=prefixSum[i-1]+chalk[i];
        
        k%=prefixSum[n-1];
        int start=0, end=chalk.length-1, ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(prefixSum[mid]>k){
                end=mid-1;
                ans=mid;
            }
            else start=mid+1;
        }
        return ans;
    }
}