class Solution {
    public boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        if(s.length()==1) return s;
        int maxLen=1;
        String maxStr = s.substring(0,1);
        for(int i=0;i<s.length();i++){
            for(int j=i+maxLen;j<=s.length();j++){
                if(j-i>maxLen && isPalindrome(s.substring(i,j))){
                    maxLen=j-i;
                    maxStr=s.substring(i,j);
                }
            }
        }
        return maxStr;

    }
}