class Solution {
    public String solve(String s){
        StringBuilder str = new StringBuilder();
        int i = 0;
        int count=1;
        while(i<s.length()-1){
            if(s.charAt(i)==s.charAt(i+1)){
                count++;
            }else{
                str.append(count).append(s.charAt(i));
                count=1;
            }
            i++;
        }
        str.append(count).append(s.charAt(i));
        return str.toString();
    }
    public String countAndSay(int n) {
        // if(n==1) return "1";
        String ans="1";
        while(n>1){
            ans=solve(ans);
            n--;
        }
        return ans;
    }
}