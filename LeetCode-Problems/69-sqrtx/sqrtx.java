class Solution {
    public int mySqrt(int x) {
        long ans=0;
        long st=0,end=x;
        while(st<=end){
            long mid=st+(end-st)/2;
            if(mid*mid>x){
                end=mid-1;
            }
            else{
                ans=mid;
                st=mid+1;
            }  
        }
        return (int)ans;
    }
}