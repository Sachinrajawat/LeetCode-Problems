class Solution {
    public String getSmallestString(String s) {
       String ans="";
       int i=1;
       for(i=1;i<s.length();i++){
        char ch1=s.charAt(i-1);
        char ch2=s.charAt(i);
        
        if((int)ch1%2==(int)ch2%2 &&ch2<ch1){
            ans=ans+ch2+ch1;
            System.out.println(ans);
            break;
        }
        else ans+=ch1;
        if(i==s.length()-1) ans+=ch2;
       }
       for(int j=i+1;j<s.length();j++) ans+=s.charAt(j);
       return ans;
    }
}