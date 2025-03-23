class Solution {
    public int countPaths(int n, int[][] roads) {
        long mod=(long)1e9+7;
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0], v=roads[i][1], w=roads[i][2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        PriorityQueue<long[]> pq=new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        long[] res=new long[n];
        Arrays.fill(res,Long.MAX_VALUE);
        int[] pathCount=new int[n];
        res[0]=0;
        pathCount[0]=1;
            pq.add(new long[]{0,0}); //{time,node}
            while(!pq.isEmpty()){
                long[] arr=pq.poll();
                long currTime=arr[0];
                int  currNode=(int)arr[1];
                 if (currTime > res[currNode]) continue;
                ArrayList<int[]> a=adj.get(currNode);
                for (int i = 0; i < adj.get(currNode).size(); i++) {
                int ngbr = adj.get(currNode).get(i)[0];
                int roadTime = adj.get(currNode).get(i)[1];
                if (currTime + roadTime < res[ngbr]) {
                    res[ngbr] = currTime + roadTime;
                    pq.add(new long[]{res[ngbr], ngbr});
                    pathCount[ngbr] = pathCount[currNode];
                } else if (currTime + roadTime == res[ngbr]) {
                    pathCount[ngbr] = (int)((pathCount[ngbr] + pathCount[currNode]) % mod);
                }
            }
            }
           
        
        return pathCount[n-1];
    }
}