class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        // ans.add(1)
        for(int i=0;i<matrix.length;i++){
            int min=matrix[i][0];
            int column=0;
            for(int j=1;j<matrix[i].length;j++){
                if(min>matrix[i][j]){
                    min=matrix[i][j];
                    column=j;
                }
            }
            int k=0;
            for(k=0;k<matrix.length;k++){
                if(min<matrix[k][column]){
                    break;
                }
            }
            if(k==matrix.length){
                ans.add(min);
            }
        }
        
        return ans;
    }
}