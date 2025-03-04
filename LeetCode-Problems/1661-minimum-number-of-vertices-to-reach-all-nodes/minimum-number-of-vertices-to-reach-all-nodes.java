class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int[] inorder=new int[n];
        for(int i=0;i<edges.size();i++){
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            inorder[edges.get(i).get(1)]++;
        }
        // System.out.println(adj);
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(inorder[i]==0) ans.add(i);
        }
        return ans;
    }
}