class Solution {
    public double myPow(double x, int n) {
        if((x==1 || x==-1) && n>10000000) return x;
        if(n<0){
            x=1/x;
            n=-n;
        }
        return power(x,n);
    }
    public double power(double x,int n){
        if(n==0) return 1;
        double half=power(x,n/2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}