class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        int[] indegree=new int[numCourses];
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }
        int count=0;
        while(!q.isEmpty()){
            int course=q.remove();
            count++;
            for (int neighbor : adj.get(course)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) q.add(neighbor);
            }
        }
        return count==numCourses;
    }
}