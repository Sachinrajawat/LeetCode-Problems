class Solution {
    public static int nextPalindrome(int num) {
        String s = Integer.toString(num);
        int len = s.length();
        
        // Handle odd and even length palindromes
        String firstHalf = s.substring(0, (len + 1) / 2); // First half of the number
        StringBuilder palindrome = new StringBuilder(firstHalf);
        if (len % 2 != 0) {
            palindrome.append(new StringBuilder(firstHalf).reverse().substring(1)); // Mirror and exclude middle
        } else {
            palindrome.append(new StringBuilder(firstHalf).reverse()); // Mirror completely
        }
        
        int palin = Integer.parseInt(palindrome.toString());
        if (palin >= num) {
            return palin;
        }

        // If generated palindrome is less than the number, increment and generate again
        int firstHalfNum = Integer.parseInt(firstHalf) + 1;
        firstHalf = Integer.toString(firstHalfNum);
        palindrome = new StringBuilder(firstHalf);
        if (len % 2 != 0) {
            palindrome.append(new StringBuilder(firstHalf).reverse().substring(1)); // Mirror and exclude middle
        } else {
            palindrome.append(new StringBuilder(firstHalf).reverse()); // Mirror completely
        }
        
        return Integer.parseInt(palindrome.toString());
    }

    public static boolean isPrime(int n){
        if(n<=1) return false;
        if(n<=3) return true;
        if(n%2==0 || n%3==0) return false;
        for(int i=5;i*i<=n;i+=6) if(n%i==0||n%(i+2)==0) return false;
        return true;
    }
    public int primePalindrome(int N) {
        if (N <= 2) return 2; // Handle edge case for smallest prime palindrome

        int candidate = N;
        while (true) {
            // Generate the next palindrome
            candidate = nextPalindrome(candidate);
            
            // If it's a prime number, return it
            if (isPrime(candidate)) {
                return candidate;
            }

            // Move to the next potential palindrome
            candidate++;

    }
}
}