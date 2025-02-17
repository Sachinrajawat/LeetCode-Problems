class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int[] indeg=new int[n];
        int[] courseTime=new int[n];
        for(int i=0;i<relations.length;i++){
            adj.get(relations[i][0]-1).add(relations[i][1]-1);
            indeg[relations[i][1]-1]++;
        }

        // System.out.println(adj);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0) q.add(i);
        }
        int last=0;
        // int len=q.size();
        // int min=0;
        // System.out.println(q);
        while(!q.isEmpty()){
            int node=q.poll();
            last=node;
            // min=Math.max(min,time[node]);
            for(int i=0;i<adj.get(node).size();i++){
                indeg[adj.get(node).get(i)]--;
                courseTime[adj.get(node).get(i)]=Math.max(courseTime[adj.get(node).get(i)],courseTime[node]+time[node]);
                if(indeg[adj.get(node).get(i)]==0){
                    q.add(adj.get(node).get(i));
                }
            }
            // len--;
            // if(len==0){
            //     len=q.size();
            //     ans+=min;
            //     min=0;
            //     System.out.println(q);
            // }
        }
        // System.out.println(last+" ");
        // for(int i:courseTime) System.out.print(i+" ");
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,courseTime[i]+time[i]);
        }
        return max;
    }
}