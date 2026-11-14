class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int st=1, end=piles[0], k=Integer.MAX_VALUE;
        for(int pile:piles){
            end=Math.max(end,pile);
        }
        while(st<=end){
            int mid=st+(end-st)/2;
            long hour=0;
            for(int pile:piles){
                hour+=(long)(pile+mid-1)/mid;
            }
            if(hour<=h){
                k=Math.min(k,mid);
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return k;
    }
}