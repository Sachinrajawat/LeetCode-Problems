class Solution {
    private static final long MOD = 1_000_000_007L;
    public long modPow(long base, long exp){
        if(exp==0) return 1;
        long half=modPow(base, exp/2);
        long result=(half*half)%MOD;
        if(exp%2==1){
            result=(result*base)%MOD;
        }
        return result;
    }
    public int countGoodNumbers(long n) {
        long evenPos=(n+1)/2;
        long oddPos=n/2;
        long evenWays=modPow(5, evenPos);
        long oddWays=modPow(4, oddPos);
        return (int)((evenWays*oddWays)%MOD);
    }
}