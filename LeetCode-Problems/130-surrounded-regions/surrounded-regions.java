class Solution {
    public boolean isValid(int i,int j,int m,int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
    public void solve(char[][] board) {
       int m=board.length;
       int n=board[0].length;
       int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
       for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                Queue<int[]> q=new LinkedList<>();
                q.add(new int[]{0,j});
                    board[0][j]='2';
                    while(!q.isEmpty()){
                        int[] arr=q.poll();
                        int u=arr[0];
                        int v=arr[1];
                        for(int i=0;i<4;i++){
                            if(isValid(u+dir[i][0],v+dir[i][1],m,n) && board[u+dir[i][0]][v+dir[i][1]]=='O'){
                                q.add(new int[]{u+dir[i][0],v+dir[i][1]});
                                board[u+dir[i][0]][v+dir[i][1]]='2';
                            }
                        }
                    }
                }
            }
            // 
        for(int j=0;j<n;j++){
            if(board[m-1][j]=='O'){
                Queue<int[]> q=new LinkedList<>();
                q.add(new int[]{m-1,j});
                    board[m-1][j]='2';
                    while(!q.isEmpty()){
                        int[] arr=q.poll();
                        int u=arr[0];
                        int v=arr[1];
                        for(int i=0;i<4;i++){
                            if(isValid(u+dir[i][0],v+dir[i][1],m,n) && board[u+dir[i][0]][v+dir[i][1]]=='O'){
                                q.add(new int[]{u+dir[i][0],v+dir[i][1]});
                                board[u+dir[i][0]][v+dir[i][1]]='2';
                            }
                        }
                    }
                }
            }
            // 
        for(int j=1;j<m-1;j++){
            if(board[j][0]=='O'){
                Queue<int[]> q=new LinkedList<>();
                q.add(new int[]{j,0});
                    board[j][0]='2';
                    while(!q.isEmpty()){
                        int[] arr=q.poll();
                        int u=arr[0];
                        int v=arr[1];
                        for(int i=0;i<4;i++){
                            if(isValid(u+dir[i][0],v+dir[i][1],m,n) && board[u+dir[i][0]][v+dir[i][1]]=='O'){
                                q.add(new int[]{u+dir[i][0],v+dir[i][1]});
                                board[u+dir[i][0]][v+dir[i][1]]='2';
                            }
                        }
                    }
                }
            }
            for(int j=1;j<m-1;j++){
            if(board[j][n-1]=='O'){
                Queue<int[]> q=new LinkedList<>();
                q.add(new int[]{j,n-1});
                    board[j][n-1]='2';
                    while(!q.isEmpty()){
                        int[] arr=q.poll();
                        int u=arr[0];
                        int v=arr[1];
                        for(int i=0;i<4;i++){
                            if(isValid(u+dir[i][0],v+dir[i][1],m,n) && board[u+dir[i][0]][v+dir[i][1]]=='O'){
                                q.add(new int[]{u+dir[i][0],v+dir[i][1]});
                                board[u+dir[i][0]][v+dir[i][1]]='2';
                            }
                        }
                    }
                }
            }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='2'){
                    board[i][j]='O';
                }
                else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        }
    }
