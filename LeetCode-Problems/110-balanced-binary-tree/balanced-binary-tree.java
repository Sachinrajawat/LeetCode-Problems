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
    public int maxHeight(TreeNode root){
        if(root==null) return 0;
        int max=Integer.MIN_VALUE;
        max=Math.max(max,1+maxHeight(root.left));
        max=Math.max(max,1+maxHeight(root.right));
        return max;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int height=Math.abs(maxHeight(root.left)-maxHeight(root.right));
        if(height>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}