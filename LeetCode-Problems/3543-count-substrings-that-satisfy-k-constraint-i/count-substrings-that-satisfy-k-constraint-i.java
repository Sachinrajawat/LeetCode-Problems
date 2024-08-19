class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int count=0;
        for(int i=0;i<s.length();i++){
            count++;
            int count0=0;
            int count1=0;
            if(s.charAt(i)=='0') count0++;
            else count1++;
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(j)=='0') count0++;
                else count1++;
                if(count0 <=k || count1<=k) count++;
                else if(count0 >k && count1>k) break;
            }
        }
        return count;
    }
}