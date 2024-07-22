class Solution {
    public String getSmallestString(String s) {
       String ans="";
       int i=1;
       for(i=1;i<s.length();i++){
        char ch=s.charAt(i);
        int c1=(int)ch-(int)'0';
        int c2=(int)s.charAt(i-1)-(int)'0';
        System.out.println(c1+" "+c2);
        if(c1%2==c2%2 &&c1<c2){
            ans=ans+ch+s.charAt(i-1);
            System.out.println(ans);
            break;
        }
        else{
            ans+=s.charAt(i-1);
        }
        if(i==s.length()-1) ans+=ch;
       }
       for(int j=i+1;j<s.length();j++){
        ans+=s.charAt(j);
       }
       return ans;
    }
}