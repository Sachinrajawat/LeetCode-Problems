class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int c0=0,max=0,i=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch=='1'){
                int left=i-1,left0=0;
                while(left>=0 && s.charAt(left)=='0'){
                    left0++;
                    left--;
                }
                while(i<s.length() && s.charAt(i)=='1'){
                    i++;
                }
                
                int right=i,right0=0;
                while(right<s.length() && s.charAt(right)=='0'){
                    right0++;
                    right++;
                }
                if(left0>0 && right0>0) max=Math.max(max,left0+right0);
                // System.out.println(left0+" "+right0+" "+max);
            }
            else{
                i++;
            }
        }
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='1') max++;
        }
        return max;
    }
}