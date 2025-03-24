class Solution {
    public int countDays(int days, int[][] meetings) {
         Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int count=0;
        int start=0,end=0;
        for(int i=0;i<meetings.length;i++){
                start=meetings[i][0];
                if(start>end){
                    count+=start-end-1;
                }
                end=Math.max(end,meetings[i][1]);
                
        }
        return count+days-end;
    }
}