/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void getMap(TreeNode root,TreeMap<Integer,ArrayList<int[]>> map,int pos,int depth){
        if(root==null) return;
        if(!map.containsKey(pos)){
            
            map.put(pos,new ArrayList<>());
        }
        
            map.get(pos).add(new int[]{depth, root.val});
        
        getMap(root.left,map,pos-1,depth+1);
        getMap(root.right,map,pos+1,depth+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,ArrayList<int[]>> map=new TreeMap<>();
        getMap(root,map,0,0);
        List<List<Integer>> ans=new ArrayList<>();
        for(var key:map.keySet()){
            List<int[]> values=map.get(key);
            values.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
            List<Integer> sortedColumn = new ArrayList<>();
            for (var pair : values) {
                sortedColumn.add(pair[1]);
            }
            ans.add(sortedColumn);
        }
        return ans;
    }
}