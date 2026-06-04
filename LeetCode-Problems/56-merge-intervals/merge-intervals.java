class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        if(n==1) return intervals;
        ArrayList<int[]> arr=new ArrayList<>();
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        int i=0;
        while(i<n){
            int[] array=intervals[i];
            int j=i+1;
            while(j<n && intervals[j][0]<=array[1]){
                array[1]=Math.max(array[1],intervals[j][1]);
                j++;
            }
            arr.add(array);
            i=j;
        }
        int[][] ans=new int[arr.size()][2];
        for(i=0;i<arr.size();i++){
            ans[i][0]=arr.get(i)[0];
            ans[i][1]=arr.get(i)[1];
        }
        return ans;
    }
}