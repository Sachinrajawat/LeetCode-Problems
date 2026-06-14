class Solution {
    public int myAtoi(String s) {
        if(s.isEmpty()) return 0;
        int i=0, n=s.length();
        boolean isNegative=false;
        while(i<n && s.charAt(i)==' ') i++;
        if(i==n) return 0;
        if(s.charAt(i)=='-'){
            isNegative=true;
            i++;
        }
        else if(s.charAt(i)=='+') i++;
        long ans=0;
        while(i<n && s.charAt(i)=='0') i++;
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch>='0' && ch<='9'){
                int digit=ch-'0';
                ans=ans*10+digit;
                if(isNegative && -ans<Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                if(!isNegative && ans>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                i++;
            }
            else{
                break;
            }
        }
        return (int)(isNegative?-1*ans:ans);
    }
}