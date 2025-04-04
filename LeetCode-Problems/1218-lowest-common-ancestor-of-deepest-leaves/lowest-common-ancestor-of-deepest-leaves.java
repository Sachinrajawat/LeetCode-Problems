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
    public TreeNode lowestCommonAncestor(TreeNode root) {
        if(root==null || map.get(root.val)== maxDepth) return root;
        TreeNode left=lowestCommonAncestor(root.left);
        TreeNode right=lowestCommonAncestor(root.right);
        if(left!=null && right!=null) return root;
        return left!=null?left:right;
    }
    HashMap<Integer,Integer> map=new HashMap<>();
    int maxDepth=0;
    public void depth(TreeNode root,int d){
        if(root==null){
            return;
        }
        maxDepth=Math.max(maxDepth,d);
        map.put(root.val,d);
        depth(root.left,d+1);
        depth(root.right,d+1);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth(root,0);
        return lowestCommonAncestor(root);
    }
}