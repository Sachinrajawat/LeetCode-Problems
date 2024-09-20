class Solution {
    public String shortestPalindrome(String s) {
        /*if(s.equals("")) return "";
        int start=0,end=s.length()-1;
        StringBuilder st=new StringBuilder(s);
        while(start<=end){
            if(st.charAt(start)!=st.charAt(end)){
                String newS=st.substring(0,start)+st.charAt(end)+st.substring(start,st.length());
                st=new StringBuilder(newS);
                start++;
            }
            else{
                start++;
                end--;
            }
            System.out.println(st+" "+start+" "+end);
    }
     return st.toString();*/
         int j = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == s.charAt(j)) { j += 1; }
    }
    if (j == s.length()) { return s; }
    String suffix = s.substring(j);
    return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }
}