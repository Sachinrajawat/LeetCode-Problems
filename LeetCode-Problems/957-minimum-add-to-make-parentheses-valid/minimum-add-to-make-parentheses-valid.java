class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(st.isEmpty()) st.push(ch);
            else{
                if(ch==')' && st.peek()=='(') st.pop();
                else st.push(ch);
            }
        }
        return st.size();
    }
}