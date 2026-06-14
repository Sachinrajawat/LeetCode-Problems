class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1) return strs[0];
        int minLen=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            minLen=Math.min(minLen, strs[i].length());
        }
        if(minLen==0) return "";
        int j=0;
        String ans="";
        while(j<minLen){
            char ch=strs[0].charAt(j);
            for(int i=0;i<strs.length;i++){
                if(ch!=strs[i].charAt(j)) return ans;
            }
            ans+=ch;
            j++;
        }
        return ans;
    }
}