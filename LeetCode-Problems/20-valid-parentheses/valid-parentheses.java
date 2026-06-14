class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        int i=0;
        while(i<s.length()){
            // System.out.println(st+" "+i);
            char ch=s.charAt(i);
            if(ch=='}' || ch==')' || ch==']'){
                if(st.isEmpty()) return false;
                char c=st.pop();
                if((c=='(' && ch==')') || (c=='{' && ch=='}') || (c=='[' && ch==']')){
                    i++;
                    continue;
                }
                else return false;
            }
            else{
                st.push(ch);
            }
            // System.out.println(ch+" "+st+" "+i);
            i++;
        }
        return st.isEmpty();
    }
}