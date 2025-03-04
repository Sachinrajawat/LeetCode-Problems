class Solution {
    // public boolean solve(int n,int pow){
    //     if(pow<0 && n!=0) return false;
    //     if(n==0) return true; 
    //     while(Math.pow(3,pow)>n) pow--;
    //     return solve(n-(int)Math.pow(3,pow),pow-1);
    // }
    public boolean checkPowersOfThree(int n) {
       while (n > 0) {
            if (n % 3 == 2) return false; 
            n /= 3; 
        }
        return true;
    }
}