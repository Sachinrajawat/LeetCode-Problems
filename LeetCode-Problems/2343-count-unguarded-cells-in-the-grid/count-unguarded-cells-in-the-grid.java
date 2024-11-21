class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] mat=new int[m][n];
        for(int i=0;i<guards.length;i++){
            int x=guards[i][0],y=guards[i][1];
            mat[x][y]=1;
        }
        for(int i=0;i<walls.length;i++){
            int x=walls[i][0],y=walls[i][1];
            mat[x][y]=1;
        }
        for(int i=0;i<guards.length;i++){
            int x=guards[i][0],y=guards[i][1];
            int down=x+1;
            while(down<m && mat[down][y]!=1){
                mat[down++][y]=-1;
            }

            int up=x-1;
            while(up>=0 && mat[up][y]!=1){
                mat[up--][y]=-1;
            }

            int left=y-1;
            while(left>=0 && mat[x][left]!=1){
                mat[x][left--]=-1;
            }
            
            int right=y+1;
            while(right<n && mat[x][right]!=1){
                mat[x][right++]=-1;
            }
        }
        
        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0) c++;
            }
        }
        return c;
    }
}