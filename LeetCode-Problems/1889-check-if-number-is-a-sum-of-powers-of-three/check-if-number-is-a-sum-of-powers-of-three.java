class Solution {
    public boolean solve(int n,int pow){
        if(pow<0 && n!=0) return false;
        if(n==0) return true; 
        while(Math.pow(3,pow)>n) pow--;
        return solve(n-(int)Math.pow(3,pow),pow-1);
    }
    public boolean checkPowersOfThree(int n) {
        // System.out.println((int)Math.cbrt(n));
        return solve(n,(int)Math.cbrt(n));
    }
}