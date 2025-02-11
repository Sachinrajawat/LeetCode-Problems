class Solution {
    public String removeOccurrences(String s, String part) {
        // System.out.println(s.contains(part));
        StringBuilder sb=new StringBuilder(s);
        int idx=0;
        int len=part.length();
        while((idx=sb.indexOf(part))!=-1){
                sb.delete(idx,idx+len);
            }
        
        return sb.toString();
    }
}