class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<expression.length();i++){
            char ch=expression.charAt(i);
            if(ch==',') continue;
            else if(ch==')'){
                Stack<Boolean> bool=new Stack<>();
                while(st.peek()!='('){
                    if(st.peek()=='f') bool.push(false);
                    else bool.push(true);
                    st.pop();
                }
                st.pop();
                char op=st.pop();
                boolean ans=bool.peek();
                if(op=='&'){
                    while(!bool.isEmpty()){
                        ans&=bool.pop();
                    }
                }
                else if(op=='|'){
                    while(!bool.isEmpty()){
                        ans|=bool.pop();
                    }
                }
                else{
                    ans=!ans;
                }
                if(ans) st.push('t');
                else st.push('f');
            }
            else{
                st.push(ch);
            }
            
        }
        
        return st.pop()=='t'?true:false;
    }
}