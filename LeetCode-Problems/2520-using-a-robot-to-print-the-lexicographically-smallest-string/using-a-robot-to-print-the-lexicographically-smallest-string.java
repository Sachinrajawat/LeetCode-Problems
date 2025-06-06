class Solution {
    public String robotWithString(String s) {
        int n=s.length();
        char[] arr=new char[s.length()];
        char last=s.charAt(n-1);
        for(int i=n-1;i>=0;i--){
            if(last>s.charAt(i)) last=s.charAt(i);
            arr[i]=last;
        }
        Stack<Character> st=new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            st.push(ch);
            while(!st.isEmpty() &&(i==n-1  || st.peek()<=arr[i+1])){
                sb.append(st.pop());
            }

        }
        while(!st.isEmpty()){
            sb.append(st.pop());

        }
        return sb.toString();
    }
}