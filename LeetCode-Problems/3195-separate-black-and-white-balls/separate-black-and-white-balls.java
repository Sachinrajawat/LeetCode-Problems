class Solution {
    public long minimumSteps(String s) {
        long count=0;
        int start=0,end=s.length()-1;
        while(start<end){
            if(s.charAt(start)=='0'){
                if(s.charAt(end)=='1'){
                    end--;
                }
                start++;
            }
            else{
                if(s.charAt(end)=='0'){
                    count+=end-start;
                    start++;
                }
                end--;
            }
        }
        return count;
    }
}