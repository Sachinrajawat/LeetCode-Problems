class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> st=new Stack<>();
        int sum=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(st.size()==0) st.push(c);
            else if(x>=y){
                if(c=='b' && st.peek()=='a'){
                    st.pop();
                    sum+=x;
                }
                else st.push(c);
            }
            else if(x<y){
                if(c=='a' && st.peek()=='b'){
                    st.pop();
                    sum+=y;
                }
                else st.push(c);
            }
        }
        Stack<Character> nst=new Stack<>();
        while(!st.isEmpty()){
            char ch=st.pop();
            if(nst.size()==0) nst.push(ch);
            else if(x>=y){
                if(ch=='b' && nst.peek()=='a'){
                    nst.pop();
                    sum+=y;
                }
                else nst.push(ch);
            }
            else if(x<y){
                if(ch=='a' && nst.peek()=='b'){
                    nst.pop();
                    sum+=x;
                }
                else nst.push(ch);
            }
        }
        return sum;
    }
}