class Solution {
    public String solve(int n){
        if(n==1) return "1";
        String str=solve(n-1);
        int i=0;
        String ans="";
        while(i<str.length()){
            int j=i+1;
            int c=1;
            while(j<str.length()){
                if(str.charAt(i)==str.charAt(j)){
                    c++;
                }else{
                    break;
                }
                j++;
            }
            ans+=String.valueOf(c)+str.charAt(i);
            i=j;
        }
        return ans;
    }
    public String countAndSay(int n) {
        return solve(n);
    }
}