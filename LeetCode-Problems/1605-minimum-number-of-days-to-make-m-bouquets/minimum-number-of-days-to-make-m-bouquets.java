class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long)n<(long)m*k) return -1;

        int st = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            st = Math.min(st, day);
            end = Math.max(end, day);
        }
        int ans=Integer.MAX_VALUE;
        while(st<=end){
            int mid=st+(end-st)/2;
            int count=0;
            int i=0;
            while(i<=n-k){
                if(bloomDay[i]<=mid){
                    boolean isbouquet=true;
                    for(int j=i;j<i+k;j++){
                        if(bloomDay[j]>mid){
                            isbouquet=false;
                            break;
                        }
                    }
                    if(isbouquet){
                        count++;
                        i+=k;
                    }
                    else{
                        i++;
                    }
                }
                else{
                    i++;
                }
            }
            if(count>=m){
                ans=Math.min(ans, mid);
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}