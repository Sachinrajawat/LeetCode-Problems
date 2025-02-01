class Solution {
    // public int solve(int[] arr,int idx){
    //     if(idx>=arr.length) return 0;
    //     return Math.max(arr[idx]+solve(arr,idx+1),solve(arr,idx+1));
    // }
    public int kConcatenationMaxSum(int[] arr, int k) {
        long mod=(long)1e9+7;
        long pref=0,suff=0,prefSum=0,suffSum=0,min=0,maxSub=0;
        for(int i=0;i<arr.length;i++){
            prefSum+=arr[i];
            maxSub=Math.max(maxSub,prefSum-min);
            min=Math.min(min,prefSum);
            suffSum+=arr[arr.length-1-i];
            pref=Math.max(pref,prefSum);
            suff=Math.max(suff,suffSum);
        }
        return k==1?(int)(maxSub%mod):(int)(Math.max(maxSub,prefSum<=0?pref+suff:pref+suff+prefSum*(k-2))%mod);
    }
}