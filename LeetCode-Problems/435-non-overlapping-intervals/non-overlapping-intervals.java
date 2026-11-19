class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{
            if(a[0]!=b[0]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });
        int i=0, j=1, count=0;
        while(j<intervals.length){
            int cs=intervals[i][0];
            int ce=intervals[i][1];
            int ns=intervals[j][0];
            int ne=intervals[j][1];
            if(ce<=ns){
                i=j;
                j++;
            }
            else if(ce<=ne){
                j++;
                count++;
            }
            else if(ce>=ne){
                i=j;
                j++;
                count++;
            }
        }
        return count;
    }
}