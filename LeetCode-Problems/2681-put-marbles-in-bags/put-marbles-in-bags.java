class Solution {
    public long putMarbles(int[] weights, int k){
        int n=weights.length;
        long[] pre=new long[n-1];
        for(int i=1;i<n;i++){
            pre[i-1]=weights[i]+weights[i-1];
        }
        Arrays.sort(pre);
        long min=0,max=0;
        for(int i=0;i<k-1;i++){
            min+=pre[i];
            max+=pre[n-2-i];
        }
        return max-min;
    }
}