class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg=new int[numCourses];
        for(int i=0;i<n;i++){
            int key=prerequisites[i][0];
            int val=prerequisites[i][1];
            adj.get(val).add(key);
            indeg[key]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0) q.add(i);
        }
        int[] ans=new int[numCourses];
        int j=0;
        while(!q.isEmpty()){
            int x=q.remove();
            ans[j++]=x;
            
            for(int i=0;i<adj.get(x).size();i++){
                indeg[adj.get(x).get(i)]--;
                if(indeg[adj.get(x).get(i)]==0) q.add(adj.get(x).get(i));
            }
        }
        // System.out.println(j);
    return j==numCourses?ans:new int[0];
    }
}