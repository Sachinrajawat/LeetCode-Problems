class Solution {
    public boolean dfs(int[][] graph,int[] color,int idx){
        // boolean ans=true;
        for(int i=0;i<graph[idx].length;i++){
            if(color[graph[idx][i]]==-1){
                color[graph[idx][i]]=(color[idx]+1)%2;
                if(!dfs(graph,color,graph[idx][i])) return false;
            }
            else{
                if(color[idx]==color[graph[idx][i]]) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
         for (int i=0;i<n;i++) {
            if (color[i]==-1) { 
                color[i]=0;
                if (!dfs(graph, color, i)) return false;
            }
        }
         
        return true;
    }
}