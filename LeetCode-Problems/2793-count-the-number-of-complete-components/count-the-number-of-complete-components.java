class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        // int[] indeg=new int[n];
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
            // indeg[edges[i][0]]++;
            // indeg[edges[i][1]]++;
        }
        // System.out.println(adj);
        int c=0;
        boolean[] isVisited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                // int x=indeg[i];
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                
                // int size-=0;
                HashSet<Integer> set=new HashSet<>();
                while(!q.isEmpty()){
                    int node=q.poll();
                    set.add(node);
                    isVisited[node]=true;
                    ArrayList<Integer> arr=adj.get(node);
                    for(int j=0;j<arr.size();j++){
                        if(!isVisited[arr.get(j)]){
                            q.add(arr.get(j));
                            // set.add(arr.get(j));
                            isVisited[arr.get(j)]=true;
                        }
                    }
                }
                boolean isComplete=true;
               for(int a:set){
                    if(adj.get(a).size()!=set.size()-1){
                        isComplete=false;
                        break;
                    }
               }
               if(isComplete) c++;
            }
        }
        return c;
    }
}