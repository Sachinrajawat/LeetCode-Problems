class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list=new ArrayList<>();
        int top=0,bottom=matrix.length-1,left=0,right=matrix[0].length-1;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            for(int i=top+1;i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            if(bottom!=top){
                for(int i=right-1;i>=left;i--){
                list.add(matrix[bottom][i]);
            }
            }
            if(left!=right){
            for(int i=bottom-1;i>top;i--){
                list.add(matrix[i][left]);
            }}
            top++;
            bottom--;
            left++;
            right--;
        }
        return list;
    }
}