class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // int max=Integer.MIN_VALUE;
        // findin
        // for(int pile:piles){
        //     max=Math.max(pile,max);
        // }
        int start=1,end=(int)10e9;
        int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            long hour=0;
            int i=0;
            while(i!=piles.length){
                hour+=piles[i]/mid;
                if(piles[i]%mid!=0) hour++;
                i++;
            }
            if(hour>h) start=mid+1;
            else{
                end=mid-1;
                ans=mid;
            }
        }
        return ans;
    }
}