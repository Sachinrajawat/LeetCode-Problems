class Solution {
    int maxPath=1;
    public int solve(ArrayList<ArrayList<Integer>> adj,String s,int node){
        if(adj.get(node).size()==0) return 1;
        int longest = 0, secondLongest = 0;
        for(int neigh:adj.get(node)){
            int childPath = solve(adj, s, neigh);
            if (s.charAt(node)!=s.charAt(neigh)){
                if(childPath>longest) {
                    secondLongest=longest;
                    longest=childPath;
                } else if(childPath>secondLongest) {
                    secondLongest=childPath;
                }
            }
        }
        maxPath = Math.max(maxPath, longest + secondLongest + 1);
        return longest + 1;
    }
    public int longestPath(int[] parent, String s) {
        int n=parent.length;
        if(n==1) return 1;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            adj.get(parent[i]).add(i);
        }
        System.out.println(adj);

        // for(int i=0;i<n;i++){

        // }
        solve(adj,s,0);
        return maxPath;
        // return 1;
    }
}