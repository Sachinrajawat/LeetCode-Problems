class Solution {
    public int minAddToMakeValid(String s) {
        int ans=0;
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            // if(ch=='(') ans++;
            // else if(ans>0) ans--;
            if(st.isEmpty()) st.push(ch);
            else{
                if(ch==')' && st.peek()=='(') st.pop();
                else st.push(ch);
            }
        }
        return st.size();
    }
}