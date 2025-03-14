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
    public int maxAns=Integer.MIN_VALUE;
    public int solve(TreeNode root){
        if(root==null) return Integer.MIN_VALUE;
        int left=Math.max(0,solve(root.left));
        int right=Math.max(0,solve(root.right));
        maxAns=Math.max(maxAns,root.val+left+right);
        return root.val+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxAns;
    }
}