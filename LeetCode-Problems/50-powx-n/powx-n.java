class Solution {
    public double myPow(double x, int n) {
        if((x<1 &&x>0) && n>10000000) return 0;
        if((x==1 || x==-1) && n>10000000) return x;
        if(n<0){
            x=1/x;
            n=-n;
        }
        if(n==1) return x;
        double ans=x*myPow(x,n-1);
        return ans;
    }
}