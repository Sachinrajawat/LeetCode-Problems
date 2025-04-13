class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(st.isEmpty()) st.push(ch);
            else if(ch=='(' || ch=='[' || ch=='{'){
                st.push(ch);
            }
            else{
                if(st.peek()=='[' && ch==']' || st.peek()=='(' && ch==')' || st.peek()=='{' && ch=='}'){
                    st.pop();
                }
                else return false;
            }
        }
        return st.isEmpty();
    }
}