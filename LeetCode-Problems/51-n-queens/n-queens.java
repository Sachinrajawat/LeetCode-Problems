class Solution {
    
    /*boolean check(int n,List<String> board,int i,int j){
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
        return true;
    }*/
    void find(int row,int n,List<List<String>> ans,List<String> board,boolean[] col,int[] leftDig,int[] rightDig){
        //Base condition
        if(row==n){
            ans.add(new ArrayList<>(board));
            return;
        }
        //put queen at any n position

        //Left Dign: n-1+col-row
        //right Dign: row+col
        for(int j=0;j<n;j++){
            if(!col[j] &&leftDig[n-1+j-row]==0 && rightDig[row+j]==0){
                col[j]=true;
                char[] rowChars = board.get(row).toCharArray();
                rowChars[j] = 'Q';
                board.set(row, new String(rowChars));
                leftDig[n-1+j-row]=1;
                rightDig[row+j]=1;
                find(row+1,n,ans,board,col,leftDig,rightDig);
                
                rowChars[j] = '.';
                board.set(row, new String(rowChars));
                col[j]=false;
                leftDig[n-1+j-row]=0;
                rightDig[row+j]=0;
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
        int[] leftDig=new int[2*n-1];
        int[] rightDig=new int[2*n-1];
        boolean[] col=new boolean[n];
        find(0,n,ans,board, col, leftDig, rightDig);
        return ans;
    }
}