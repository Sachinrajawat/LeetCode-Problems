class Solution {
    public long solve(String str,String s, int limit){
        if(str.length() < s.length()) return 0;

        long count=0;
        String trailStr = str.substring(str.length()-s.length());

        int remLen = str.length() - s.length();

        for(int i=0;i<remLen;i++){
            int digit = str.charAt(i)-'0';

            if(digit<=limit){
                count+= digit*Math.pow(limit+1, remLen-i-1);
            }
            else{
                count+= Math.pow(limit+1,remLen-i);
                return count;
            }
        }
        if(trailStr.compareTo(s) >= 0)  count++;
        return count;
    }
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        
        
        long ans=0;
        String fin=Long.toString(finish);
        String st=Long.toString(start-1);
        
        return solve(fin, s, limit) - solve(st, s, limit);
    }
}