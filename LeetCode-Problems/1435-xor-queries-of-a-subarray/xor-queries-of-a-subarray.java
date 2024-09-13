class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int val=0;
            int start=queries[i][0],end=queries[i][1];
            for(int j=start;j<=end;j++){
                val=val^arr[j];
            }
            ans[i]=val;
        }
        return ans;
    }
}