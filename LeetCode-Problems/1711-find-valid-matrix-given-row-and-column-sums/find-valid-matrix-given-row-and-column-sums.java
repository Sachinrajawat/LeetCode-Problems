class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m=rowSum.length,n=colSum.length;
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            int x=rowSum[i];
            for(int j=0;j<n;j++){
                if(x<=colSum[j]){
                    ans[i][j]=x;
                    colSum[j]-=x;
                    x=0;
                }
                else{
                    ans[i][j]=colSum[j];
                    x-=colSum[j];
                    colSum[j]=0;
                }
            }
        }
        return ans;
    }
}