class Solution {
    public int findComplement(int num) {
        String bin=Integer.toBinaryString(num);
        String comp="";
        for(int i=0;i<bin.length();i++){
            char ch=bin.charAt(i);
            if(ch=='0') comp+='1';
            else comp+='0';
        }
        return Integer.parseInt(comp,2);
    }
}