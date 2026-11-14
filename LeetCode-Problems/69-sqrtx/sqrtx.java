class Solution {
    public int mySqrt(int x) {
        int st=0, end=x;
        int ans=Integer.MIN_VALUE;
        while(st<=end){
            int mid=st+(end-st)/2;
            long product=(long)mid*mid;
            if(product<x){
                ans=Math.max(ans, mid);
                st=mid+1;
            }
            else if(product==x) return mid;
            else{
                end=mid-1;
            }
        }
        return ans;
    }
}