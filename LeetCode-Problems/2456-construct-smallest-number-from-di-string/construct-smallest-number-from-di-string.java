class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> st=new Stack<>();
        Stack<Integer> dec=new Stack<>();
        st.push(1);
        int num=1;
        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            if(ch=='I'){
                while(!dec.isEmpty()){
                    st.push(dec.pop());
                }
                st.push(++num);
                
            }
            else{
                if(dec.isEmpty()){
                dec.push(st.pop());
                }
                dec.push(++num);
            }
        }
        String ans="";
        while(!st.isEmpty()){
            ans=st.pop()+ans;
        }
        while(!dec.isEmpty()){
            ans+=dec.pop();
        }
        return ans;
    }
}