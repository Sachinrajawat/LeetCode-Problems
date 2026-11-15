class Solution {
    public String removeOuterParentheses(String s) {
        String ans="";
        int n=s.length();
        int st=0;
        int i=0, count=0;
        while(i<n){
            char ch=s.charAt(i);
            if(ch=='('){
                count++;
            }else{
                count--;
                if(count==0){
                    ans+=s.substring(st+1,i);
                    st=i+1;
                }
            }
            i++;
        }
        return ans;
    }
}