class Solution {
    public String simplifyPath(String path) {
        String[] arr=path.split("/");
        int j=0;
        String ans="";
        Stack<String> st=new Stack<>();
        st.push("/");
        for(int i=0;i<arr.length;i++){
            if(!st.peek().equals("/")) st.push("/");
            if(arr[i].equals(".") || arr[i].equals("")){
                continue;
            }
            else if(arr[i].equals("..")){
                if(st.size()>1) st.pop();
                if(st.size()>1) st.pop();
            }
            else st.push(arr[i]);

        }
        if(st.size()>1 && st.peek().equals("/")) st.pop(); 
        while(!st.isEmpty()) ans=st.pop()+ans;
        return ans;
    }
}