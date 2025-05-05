class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                q.add(i);
                color[i]=0;
                while(!q.isEmpty()){
                    int x=q.remove();
                    int[] arr=graph[x];
                    for(int j=0;j<arr.length;j++){
                        if(color[arr[j]]==color[x]) return false;
                        if(color[arr[j]]==-1){
                            if(color[x]==0) color[arr[j]]=1;
                            else color[arr[j]]=0;
                            q.add(arr[j]);
                        }
                    }
                }
            }
        }
        return true;
    }
}