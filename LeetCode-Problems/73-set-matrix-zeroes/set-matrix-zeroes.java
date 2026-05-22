class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length, m=matrix[0].length;
        HashSet<Integer> row=new HashSet<>();
        HashSet<Integer> col=new HashSet<>();
        // System.out.println(n+" "+m);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        // System.out.println(row+" "+col);
        for(var r:row){
            for(int j=0;j<m;j++){
                matrix[r][j]=0;
            }
        }
        for(var c:col){
            for(int i=0;i<n;i++){
                matrix[i][c]=0;
            }
        }
    }
}