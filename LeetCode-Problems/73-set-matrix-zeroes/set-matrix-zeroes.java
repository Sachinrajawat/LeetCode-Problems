class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> row=new HashSet<>();
        HashSet<Integer> col=new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(var val:row){
            for(int i=0;i<matrix[0].length;i++) matrix[val][i]=0;
        }
        for(var val:col){
            for(int i=0;i<matrix.length;i++) matrix[i][val]=0;
        }
        System.out.println(row+" "+col);
    }
}