class Solution {
    public boolean isPalindrome(String s, int st, int end,Boolean[][] dp){
        if(st>=end) return true;
        if(dp[st][end]!=null) return dp[st][end];
        if(s.charAt(st)==s.charAt(end)) 
            return dp[st][end]=isPalindrome(s, st+1, end-1,dp);
        return dp[st][end]=false;
    }
    
    public String longestPalindrome(String s) {
        int n=s.length();
        int maxLen=0;
        int sp=0;
        Boolean[][] dp=new Boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s, i, j, dp)){
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