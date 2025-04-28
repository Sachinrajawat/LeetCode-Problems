class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n=nums.length;
        long[] pref=new long[n+1];
        pref[0]=0;
        for(int i=1;i<=n;i++){
            pref[i]=pref[i-1]+nums[i-1];
        }
        long count=0;
        int j=0,l=1;
        while(l<=n){
            while(j<l && (long)(pref[l]-pref[j])*(l-j)>=k){
                j++;
            }
            count+=l-j;
            l++;
        }
        return count;
    }
}