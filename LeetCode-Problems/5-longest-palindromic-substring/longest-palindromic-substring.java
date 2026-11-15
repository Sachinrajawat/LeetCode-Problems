class Solution {
    public boolean isPalindrome(String s, int st, int end){
        if(st>=end) return true;
        if(s.charAt(st)==s.charAt(end)) 
        return isPalindrome(s, st+1, end-1);
        return false;
    }
    
    public String longestPalindrome(String s) {
        int n=s.length();
        int maxLen=0;
        int sp=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s, i, j)){
                    if(j-i+1>maxLen){
                        maxLen=j-i+1;
                        sp=i;
                    }
                }
            }
        }
        return s.substring(sp, sp+maxLen);
    }
}