class Solution {
    public String compressedString(String word) {
        String comp="";
        int count=1,i=0;
        while(i<word.length()-1){
            if(word.charAt(i)==word.charAt(i+1)){
                count++;
            }
            else{
                comp=comp+count+word.charAt(i);
                count=1;
            }
            if(count==9){
                comp=comp+count+word.charAt(i);
                count=1;
                i++;
            }
            i++;
        }
        if(word.length()!=i)comp=comp+count+word.charAt(word.length()-1);
        return comp;
    }
}