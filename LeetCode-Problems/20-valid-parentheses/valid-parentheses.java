class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        int size=s.length();
        if(size%2!=0) return false;
        for(int i=0;i<size;i++){
            char ch=s.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                st.push(ch);
            }
            else{
                if(st.size()==0) return false;
                char d=st.peek();
                if(ch==']'){
                    if(d=='[') st.pop();
                    else return false;
                }
                else if(ch==')'){
                    if(d=='(') st.pop();
                    else return false;
                }
                else{
                    if(d=='{') st.pop();
                    else return false;
                }
            }
        }
        if(st.size()>0) return false;
        else return true;
    }
}