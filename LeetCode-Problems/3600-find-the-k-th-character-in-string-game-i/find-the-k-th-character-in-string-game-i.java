class Solution {
    public char kthCharacter(int k) {
        String s="a";
        while(s.length()<k){
            String str="";
            for(int i=0;i<s.length();i++){
                int ch=(int)s.charAt(i);
                char c=(char)(ch+1);
                str+=c;
            }
            s+=str;
        }
        return s.charAt(k-1);
    }
}