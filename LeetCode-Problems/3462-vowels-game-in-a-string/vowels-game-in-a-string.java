class Solution {
    public boolean doesAliceWin(String st) {
        StringBuilder s=new StringBuilder(st);
        int v=0;
        for(int i=0;i<st.length();i++){
            char ch=st.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                v++;
            }
        }
        if(v==0) return false;
        return true;
    }
}