class Solution {
    public String longestCommonPrefix(String[] strs) {
        // if(strs.length==1) return strs[0];
        Arrays.sort(strs);
        String s1=strs[0], s2=strs[strs.length-1];
        int i=0;
        while(i<s1.length() && i<s2.length() && s1.charAt(i)==s2.charAt(i)){
            i++;
        }
        return s1.substring(0, i);
    }
}