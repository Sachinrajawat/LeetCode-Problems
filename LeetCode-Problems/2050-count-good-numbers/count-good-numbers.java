class Solution {
    
    public int countGoodNumbers(long n) {
        int count=1;
        long oddPos=n/2;
        long evenPos=(n+1)/2;
        long mod = 1000000007;
        return (int)((power(4,oddPos,mod)*power(5,evenPos,mod))%mod);
    }
    public long power(long base, long exp,long mod){
        long result=1;
        base%=mod;
        while(exp>0){
            if(exp%2==1){
                result=(result*base)%mod;
            }
            base=(base*base)%mod;
            exp/=2;
        }
        return result;
    }
}