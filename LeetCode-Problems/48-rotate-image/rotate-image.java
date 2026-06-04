class Solution {
    public void rotate(int[][] matrix) {
        int row=matrix.length, col=matrix[0].length;
        int[][] mat=new int[row][col];
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                mat[j][col-i-1]=matrix[i][j];
            }
        }
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                matrix[i][j]=mat[i][j];
            }
        }
    }
}