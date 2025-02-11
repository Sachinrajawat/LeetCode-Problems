class Solution {
    public boolean isValid(int i,int j,int m,int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
    public void solve(char[][] board) {
       int m=board.length;
       int n=board[0].length;
       int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    if(board[i][j]=='O'){
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{i,j});
                        board[i][j]='2';
                        while(!q.isEmpty()){
                            int[] arr=q.poll();
                            int u=arr[0];
                            int v=arr[1];
                            for(int k=0;k<4;k++){
                                if(isValid(u+dir[k][0],v+dir[k][1],m,n) && board[u+dir[k][0]][v+dir[k][1]]=='O'){
                                    q.add(new int[]{u+dir[k][0],v+dir[k][1]});
                                    board[u+dir[k][0]][v+dir[k][1]]='2';
                                }
                            }
                        }
                    }
                }
            }
       }
    
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='2') board[i][j]='O';
                else if(board[i][j]=='O') board[i][j]='X';
            }
        }
    }
}
