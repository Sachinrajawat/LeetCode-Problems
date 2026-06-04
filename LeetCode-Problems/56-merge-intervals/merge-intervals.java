class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        if(n==1) return intervals;
        ArrayList<int[]> arr=new ArrayList<>();
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        arr.add(intervals[0]);
        for(int i=1;i<n;i++){
            if(arr.get(arr.size()-1)[1]>=intervals[i][0]){
                arr.get(arr.size()-1)[1]=Math.max(arr.get(arr.size()-1)[1],intervals[i][1]);
            }else arr.add(intervals[i]);
        }
        int[][] ans=new int[arr.size()][2];
        for(int i=0;i<arr.size();i++){
            ans[i][0]=arr.get(i)[0];
            ans[i][1]=arr.get(i)[1];
        }
        return ans;
    }
}