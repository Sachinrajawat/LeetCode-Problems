class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans=new int[2];
        int n=grid.length;
        int[] freq=new int[n*n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(freq[grid[i][j]-1]==0) freq[grid[i][j]-1]++;
                else ans[0]=grid[i][j];
            }
        }
        for(int i=0;i<n*n;i++){
            if(freq[i]==0){
                ans[1]=i+1;
                break;
            }
        }
        return ans;
    }
}