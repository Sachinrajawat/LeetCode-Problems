class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int j=0;
        while(j<n){
            pq.add(matrix[j][j]);
                for(int i=j+1;i<n;i++){
                    pq.add(matrix[j][i]);
                    pq.add(matrix[i][j]);
                }
                // if(pq.size()>=k) break;
            j++;
        }
        int ans=0;
        while(k>0){
            ans=pq.remove();
            k--;
        }
        return ans;
    }
}