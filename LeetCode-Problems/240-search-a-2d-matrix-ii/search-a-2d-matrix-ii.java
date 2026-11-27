class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length;
        int st=0, end=n-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==target) return true;
            }
        }
        return false;
        // while(st<=end){
        //     int mid=st+(end-st)/2;
        //     if(matrix[mid][0]>target){
        //         end=mid-1;
        //     }
        //     else if(matrix[mid][n-1]<target){
        //         st=mid+1;
        //     }
        //     else{
                
        //     }
        // }
    }
}