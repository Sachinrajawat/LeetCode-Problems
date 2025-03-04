class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inorder=new int[n];
        for(int i=0;i<edges.size();i++){
            inorder[edges.get(i).get(1)]++;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(inorder[i]==0) ans.add(i);
        }
        return ans;
    }
}