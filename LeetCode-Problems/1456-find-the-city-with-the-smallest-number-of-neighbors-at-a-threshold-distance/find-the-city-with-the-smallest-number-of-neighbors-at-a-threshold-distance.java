class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(mat[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<edges.length;i++){
            mat[edges[i][0]][edges[i][1]]=edges[i][2];
            mat[edges[i][1]][edges[i][0]]=edges[i][2];
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                if(mat[i][k]==Integer.MAX_VALUE) continue;
                for(int j=0;j<n;j++){
                    if(mat[k][j]==Integer.MAX_VALUE || i==j) continue;
                    mat[i][j]=Math.min(mat[i][j],mat[i][k]+mat[k][j]);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        int ans=0,c=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(mat[i][j]<=distanceThreshold) count++;
            }
            if(c>=count){
                c=count;
                ans=i;
            }
        }
        return ans;
    }
}