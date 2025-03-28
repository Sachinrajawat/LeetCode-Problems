class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int n=queries.length;
        int[] ans=new int[n];
        int[][] querie=new int[n][2];
        for(int i=0;i<n;i++){
            querie[i][0]=queries[i];
            querie[i][1]=i;
        }
        Arrays.sort(querie, Comparator.comparingInt(a -> a[0]));
        boolean[][] isVisited=new boolean[grid.length][grid[0].length];
        int sum=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{grid[0][0],0,0});
        int count=0;
        int[] r={-1,1,0,0};
        int[] c={0,0,-1,1};
        isVisited[0][0] = true;
        for(int i=0;i<n;i++){
            int q=querie[i][0];
            while(!pq.isEmpty() && pq.peek()[0] < q){
                count++;
                int[] arr=pq.poll();
                for (int j = 0; j < 4; j++) {
                    int newRow = arr[1] + r[j];
                    int newCol = arr[2] + c[j];

                    if (newRow>=0&&newRow<grid.length &&
                        newCol>=0&&newCol<grid[0].length &&
                        !isVisited[newRow][newCol]){
                        isVisited[newRow][newCol] = true;
                        pq.add(new int[]{grid[newRow][newCol], newRow, newCol});
                    }
                }
            }
             ans[querie[i][1]]=count;
        }
        return ans;
    }
}