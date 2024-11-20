class Solution {
    

    public int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        int n=s.length();
        int[] dp=new int[n+1];
        int curr=0,prev=0;
        for(int i=1;i<n+1;i++){
            curr=0;
            prev=0;
            for(int j=1;j<n+1;j++){
                prev=curr;
                curr=dp[j];
                if(s.charAt(i-1)==sb.charAt(j-1)){
                    dp[j]=1+prev;
                }
                else{
                    dp[j]=Math.max(dp[j],dp[j-1]);
                }
            }
        }
        return dp[n];
    }
}