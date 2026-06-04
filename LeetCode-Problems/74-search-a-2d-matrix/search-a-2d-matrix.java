class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length;
        int row=-1;
        for(int i=0;i<m;i++){
            if(matrix[i][0]<=target && matrix[i][n-1]>=target){
                row=i;
                break;
            }
        }
        if(row==-1) return false;
        int st=0, end=n;
        System.out.println(row);
        while(st<=end){
            int mid=st+(end-st)/2;
            if(matrix[row][mid]==target){
                return true;
            }else if(matrix[row][mid]>target){
                end=mid-1;
            }
            else st=mid+1;
        }
        return false;
    }
}