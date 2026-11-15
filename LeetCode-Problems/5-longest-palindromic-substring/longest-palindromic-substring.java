class Solution {
    public int isPalindrome(String s, int st, int end,int[][] dp){
        if(st>=end) return 1;
        if(dp[st][end]!=-1) return dp[st][end];
        if(s.charAt(st)==s.charAt(end)) 
            return dp[st][end]=isPalindrome(s, st+1, end-1,dp);
        return dp[st][end]=0;
    }
    
    public String longestPalindrome(String s) {
        int n=s.length();
        int maxLen=0;
        int sp=0;
        int[][] dp=new int[1001][1001];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s, i, j, dp)==1){
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