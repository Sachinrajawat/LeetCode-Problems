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
    public boolean isEqual(TreeNode r1,TreeNode r2){
        if(r1==null || r2==null) return r1==r2;
        if(r1.val!=r2.val) return false;
        return isEqual(r1.right,r2.left)&&isEqual(r1.left,r2.right);
    }
    public boolean isSymmetric(TreeNode root) {
        return root==null || isEqual(root.left,root.right);
    }
}