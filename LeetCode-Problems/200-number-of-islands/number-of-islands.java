class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    q.add(new int[]{i,j});
                    grid[i][j]='2';
                    while(!q.isEmpty()){
                        int[] arr=q.poll();
                        int r=arr[0];
                        int c=arr[1];
                        if(r-1>=0 && grid[r-1][c]=='1'){
                            q.add(new int[]{r-1,c});
                            grid[r-1][c]='2';
                        }
                        if(r+1<m && grid[r+1][c]=='1'){
                            q.add(new int[]{r+1,c});
                            grid[r+1][c]='2';
                        }
                        if(c-1>=0 && grid[r][c-1]=='1'){
                            q.add(new int[]{r,c-1});
                            grid[r][c-1]='2';
                        }
                        if(c+1<n && grid[r][c+1]=='1'){
                            q.add(new int[]{r,c+1});
                            grid[r][c+1]='2';
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}