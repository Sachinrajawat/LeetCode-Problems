class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length;
        int st=0, end=m-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(matrix[mid][0]>target){
                end=mid-1;
            }else if(matrix[mid][n-1]<target){
                st=mid+1;
            }else{
                int st1=0, end1=n-1;
                while(st1<=end1){
                    int mid1=st1+(end1-st1)/2;
                    if(matrix[mid][mid1]==target) return true;
                    else if(matrix[mid][mid1]>target){
                        end1=mid1-1;
                    }else{
                        st1=mid1+1;
                    }
                }
                break;
            }
        }
        return false;
    }
}