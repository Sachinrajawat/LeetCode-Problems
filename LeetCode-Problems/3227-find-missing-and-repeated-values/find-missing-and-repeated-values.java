class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int[] arr=new int[n*n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[grid[i][j]-1]++;
            }
        }
        int[] ans=new int[2];
        for(int i=0;i<n*n;i++){
            if(arr[i]==2) ans[0]=i+1;
            else if(arr[i]==0) ans[1]=i+1;
        }
        return ans;
    }
}