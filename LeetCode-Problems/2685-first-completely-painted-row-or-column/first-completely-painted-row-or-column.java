class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m=mat.length, n=mat[0].length;
        Map<Integer,int[]> map=new TreeMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map.put(mat[i][j],new int[]{i,j});
            }
        }
        int[] row=new int[m];
        int[] col=new int[n];
        for(int i=0;i<arr.length;i++){
            int[] a=map.get(arr[i]);
            row[a[0]]++;
            col[a[1]]++;
            if(row[a[0]]==n || col[a[1]]==m) return i;
        }
        return 0;
    }
}