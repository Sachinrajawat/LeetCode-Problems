class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top=0,left=0,bottom=matrix.length-1,right=matrix[0].length-1;
        List<Integer> list=new ArrayList<>();
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            for(int i=top+1;i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            if(top!=bottom){  
                for(int i=right-1;i>=left;i--){
                list.add(matrix[bottom][i]);
                }
            }
            if(left!=right){
                for(int i=bottom-1;i>top;i--){
                    list.add(matrix[i][left]);
                }
            }
            top++;
            right--;
            bottom--;
            left++;
        }
        return list;
    }
}