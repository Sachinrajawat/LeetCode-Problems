class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        Set<Integer> row=new HashSet<>();
        Set<Integer> col=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                   row.add(i);
                   col.add(j);
                }
            }
        }
        for(var element:row){
            for(int i=0;i<n;i++){
                matrix[element][i]=0;
            }
        }
        for(var element:col){
            for(int i=0;i<m;i++){
                matrix[i][element]=0;
            }
        }
    }
}