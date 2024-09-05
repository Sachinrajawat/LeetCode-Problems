class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length-1;
        /*int[][] nMatrix=new int[n][n];
        int k=matrix[0].length-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                nMatrix[j][k]=matrix[i][j];
            }
            k--;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(nMatrix[i][j]+" ");
            }
            System.out.println();
        }*/
        for(int i=0;i<n+1/2;i++){
            for(int j=i;j<n-i;j++){
                System.out.println(i);
                int x=matrix[j][n-i];
                if(i==1) System.out.println(x);
                matrix[j][n-i]=matrix[i][j];
                int y=matrix[n-i][n-j];
                if(i==1) System.out.println(y);
                matrix[n-i][n-j]=x;
                x=matrix[n-j][i];
                // System.out.println(x);
                matrix[n-j][i]=y;
                matrix[i][j]=x;
            }
        }
    }
}