class Solution {
    public boolean checker(int i,int j,int idx,String word,char[][] board,int[][] dir){
       if(idx==word.length()) return true;
       if(i<0 || j<0 || i>=board.length || j>=board[i].length || board[i][j]=='$' ||board[i][j]!=word.charAt(idx)) return false;
       char temp=board[i][j];
       board[i][j]='$';
        for(int k=0;k<4;k++){
            int x=i+dir[k][0];
            int y=j+dir[k][1];
            if(checker(x,y,idx+1,word,board,dir)) return true;
        }
       board[i][j]=temp;
       return false;
    }
    public boolean exist(char[][] board, String word) {
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0) && checker(i,j,0,word,board,dir)){
                    return true;
                }
            }
        }
        return false;
    }
}