class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int time=-1;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        int len=q.size();
        int l=0;
        while(l<len){
            int[] arr=q.poll();
            int r=arr[0];
            int c=arr[1];
            // System.out.print(grid[r][c]+" "+r+" "+c+" ");
            if(r-1>=0 && grid[r-1][c]==1){
                q.add(new int[]{r-1,c});
                grid[r-1][c]=2;
            }
            if(r+1<m && grid[r+1][c]==1){
                q.add(new int[]{r+1,c});
                grid[r+1][c]=2;
            }
            if(c-1>=0 && grid[r][c-1]==1){
                q.add(new int[]{r,c-1});
                grid[r][c-1]=2;
            }
            if(c+1<n && grid[r][c+1]==1){
                q.add(new int[]{r,c+1});
                grid[r][c+1]=2;
            }
            l++;
            if(l==len){
                time++;
                l=0;
                len=q.size();
            }
            // System.out.println(time);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return time==-1?0:time;
    }
}