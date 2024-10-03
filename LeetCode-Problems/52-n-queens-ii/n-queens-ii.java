class Solution {
    public void find(int row,int n,int[] count,List<String> board,boolean[] col,int[] leftDiag,int[] rightDiag){
         if(row==n){
            // list.add(new ArrayList<>(board));
            count[0]++;
            return;
        }
        for(int j=0;j<n;j++){
            if(!col[j] && leftDiag[n-1+j-row]==0 && rightDiag[row+j]==0){
                col[j]=true;
                char[] rowChars = board.get(row).toCharArray();
                rowChars[j] = 'Q';
                board.set(row, new String(rowChars));
                leftDiag[n-1+j-row]=1;
                rightDiag[row+j]=1;
                find(row+1,n,count,board,col,leftDiag,rightDiag);
                
                rowChars[j] = '.';
                board.set(row, new String(rowChars));
                col[j]=false;
                leftDiag[n-1+j-row]=0;
                rightDiag[row+j]=0;
            }
        }
    }
    public int totalNQueens(int n) {
        // List<List<String>> list=new ArrayList<>();
        int[] count={0};
        List<String> board=new ArrayList<>();
        for(int i=0;i<n;i++){
            String s="";
            for(int j=0;j<n;j++){
                s+=".";
            }
            board.add(s);
        }
        int[] leftDiag=new int[2*n-1];
        int[] rightDiag=new int[2*n-1];
        boolean[] col=new boolean[n];
        find(0,n,count,board, col, leftDiag, rightDiag);
        return count[0];
    }
}