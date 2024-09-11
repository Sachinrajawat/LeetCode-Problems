class Solution {
    public int minBitFlips(int start, int goal) {
        String st=Integer.toBinaryString(start);
        String gl=Integer.toBinaryString(goal);
        if(st.length()>gl.length()){
            int x=st.length()-gl.length();
            while(x>0){
                gl='0'+gl;
                x--;
            }
        }
        else if(st.length()<gl.length()){
            int x=gl.length()-st.length();
            while(x>0){
                st='0'+st;
                x--;
            }
        }
        int i=st.length()-1,count=0;
        while(i>=0){
            if(st.charAt(i)!=gl.charAt(i)) count++;
            i--;
        }
        return count;
    }
}