class Solution {
    public boolean solve(String s, int idx, int open, int[][] dp){
        if(idx==s.length()) return open==0;
        if(dp[idx][open]!=-1) return dp[idx][open]==1;
        char ch=s.charAt(idx);

        boolean ans=false;

        if(ch=='('){
            ans=solve(s,idx+1,open+1,dp);
        }
        else if(ch==')' && open>0){
            ans=solve(s,idx+1,open-1,dp);
        }
        else if(ch=='*'){
            ans|=solve(s, idx+1, open+1,dp);
            ans|=solve(s, idx+1, open,dp);
            if(open>0) ans|=solve(s, idx+1, open-1,dp);
        }
        
        dp[idx][open]=ans?1:0;
        return ans;
    }
    public boolean checkValidString(String s) {
        int[][] dp=new int[s.length()][s.length()+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return solve(s, 0, 0,dp);
    }
}