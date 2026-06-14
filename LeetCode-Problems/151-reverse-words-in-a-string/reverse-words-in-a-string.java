class Solution {
    public String reverseWords(String s) {
        int len=s.length();
        int i=0;
        ArrayList<String> arr=new ArrayList<>();
        while(i<len && s.charAt(i)==' ') i++;
        String ans="";
        while(i<len){
            String str="";
            while(i<len && s.charAt(i)!=' '){
                str+=s.charAt(i);
                i++;
            }
            ans=str+ans;
            while(i<len && s.charAt(i)==' ') i++;
            if(i!=len) ans=" "+ans;
        }
        return ans;
    }
}