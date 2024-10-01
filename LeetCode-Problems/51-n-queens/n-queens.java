class Solution {
    
    boolean check(int n,List<String> board,int i,int j){
        //upper left Diagonal, koi bhi queen present naa ho
        int row=i,col=j;
        while(row>=0 && col>=0){
            if(board.get(row).charAt(col)=='Q')
            return false;
            row--;
            col--;
        }
        //upper Right Diagonal, koi bhi queen present naa ho
        row=i;
        col=j;
        while(row>=0 && col<n){
            if(board.get(row).charAt(col)=='Q')
            return false;
            row--;
            col++;
        }
        for (row = 0; row < i; row++) {
            if (board.get(row).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
    void find(int row,int n,List<List<String>> ans,List<String> board,boolean[] col){
        //Base condition
        if(row==n){
            ans.add(new ArrayList<>(board));
            return;
        }
        //put queen at any n position
        for(int j=0;j<n;j++){
            if(!col[j] && check(n,board,row,j)){
                col[j]=true;
                char[] rowChars = board.get(row).toCharArray();
                rowChars[j] = 'Q';
                board.set(row, new String(rowChars));
                find(row+1,n,ans,board,col);
                
                rowChars[j] = '.';
                board.set(row, new String(rowChars));
                col[j]=false;
            }
        }

    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        List<String> board=new ArrayList<>();
        for(int i=0;i<n;i++){
            String s="";
            for(int j=0;j<n;j++){
                s+=".";
            }
            board.add(s);
        }
        boolean[] col=new boolean[n];
        find(0,n,ans,board,col);
        return ans;
    }
}