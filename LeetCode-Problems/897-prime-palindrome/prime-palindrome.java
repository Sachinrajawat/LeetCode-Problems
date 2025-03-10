class Solution {
    public int primePalindrome(int n) {
        int num=n;
        while(n>0){
            if(prime(num)==1 && palindrome(num)==1){
                return num;
            }
            num++;
            if(num >10000000 && num<100000000){
                num=100000000;
            }
        }
        return num;
    }
    public static int prime(int num){
        if(num<=1) return 0;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0) return 0;
        }
        return 1;
    }
    public static int palindrome(int num){
        if(num<0) return 0;
        int origin=num;
        int rev=0;
        while(num>0){
            int rem=num%10;
            rev=rev*10+rem;
            num/=10;
        }
        return rev==origin?1:0;
    }
}