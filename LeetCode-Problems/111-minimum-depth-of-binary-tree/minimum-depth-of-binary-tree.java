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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.right==null && root.left==null) return 1;
        int min=Integer.MAX_VALUE;
        if(root.right==null && root.left!=null) min=Math.min(min,1+minDepth(root.left));
        else if(root.right!=null && root.left==null) min=Math.min(min,1+minDepth(root.right));
        else if(root.right!=null && root.left!=null){
            min=Math.min(min,1+minDepth(root.left));
            min=Math.min(min,1+minDepth(root.right));
        }
        System.out.println(min);
        return min;
    }
}