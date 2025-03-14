class Solution {
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        int st=1,end=candies[candies.length - 1];
        int res=0;
        while(st<=end){
            int mid=st+(end-st)/2;
             long count = 0;
            for (int candy:candies) {
                count+=candy/mid;
            }
            if(count>=k){
                res=mid;
                st=mid+1;
            }
            else end=mid-1;
        }
        return res;
    }
}