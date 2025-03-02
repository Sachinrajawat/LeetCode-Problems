class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0) return -1;
        if(n==1) return 1;
        int[] row={1,-1,0,0,-1,-1,1,1};
        int[] col={0,0,1,-1,-1,1,-1,1};
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,1});
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int i=arr[0];
            int j=arr[1];
            int d=arr[2];
            // System.out.println(i+" "+j+" "+d);
            for(int k=0;k<8;k++){
                int new_i=i+row[k];
                int new_j=j+col[k];
                if(new_i>=0 && new_i<n && new_j>=0 && new_j<n && grid[new_i][new_j]==0){
                    if(new_i==n-1 && new_j==n-1) return d+1;
                    grid[new_i][new_j]=1;
                    q.add(new int[]{new_i,new_j,d+1});
                }
            }
        }
        return -1;
    }
}