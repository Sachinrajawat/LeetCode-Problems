class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        int i=0;
        for(char ch:s.toCharArray()){
            if(ch=='}' || ch==')' || ch==']'){
                if(st.isEmpty()) return false;
                char c=st.pop();
                if((ch==')' && c!='(') || (ch=='}' && c!='{') || (ch==']' && c!='[')){
                    return false;
                }
            }
            else{
                st.push(ch);
            }
        }
        return st.isEmpty();
    }
}