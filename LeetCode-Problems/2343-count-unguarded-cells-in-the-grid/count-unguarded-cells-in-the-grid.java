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
            while(down<m){
                if(mat[down][y]==1) break;
                else mat[down][y]=-1;
                down++;
            }
            int up=x-1;
            while(up>=0){
                if(mat[up][y]==1) break;
                else mat[up][y]=-1;
                up--;
            }
            int left=y-1;
            while(left>=0){
                if(mat[x][left]==1) break;
                else mat[x][left]=-1;
                left--;
            }
            int right=y+1;
            while(right<n){
                if(mat[x][right]==1) break;
                else mat[x][right]=-1;
                right++;
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