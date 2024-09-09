class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        int k=1;
        int top=0,left=0,bottom=n-1,right=n-1;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                matrix[top][i]=k++;
            }
            for(int i=top+1;i<=bottom;i++){
                matrix[i][right]=k++;
            }
            if(top!=bottom){  
                for(int i=right-1;i>=left;i--){
                matrix[bottom][i]=k++;
                }
            }
            if(left!=right){
                for(int i=bottom-1;i>top;i--){
                    matrix[i][left]=k++;
                }
            }
            top++;
            right--;
            bottom--;
            left++;
        }
        return matrix;
    }
}