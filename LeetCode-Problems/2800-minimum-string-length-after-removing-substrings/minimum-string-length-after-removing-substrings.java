class Solution {
    public int minLength(String s) {
        boolean a=true;
        while(a){
                a=false;
                for(int i=0;i<s.length()-1;i++){
                    if(s.substring(i,i+2).equals("AB") || s.substring(i,i+2).equals("CD")){
                        s=s.substring(0,i)+s.substring(i+2,s.length());
                        a=true;
                    }
                }
        }
        return s.length();
    }
}