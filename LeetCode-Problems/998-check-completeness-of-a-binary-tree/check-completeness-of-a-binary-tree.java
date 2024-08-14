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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean foundNullChild=false;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            
            // Left child check
            if (node.left != null) {
                if (foundNullChild) return false;
                queue.offer(node.left);
            } else {
                foundNullChild = true; // Left child is missing, flag it
            }
            
            // Right child check
            if (node.right != null) {
                if (foundNullChild) return false;
                queue.offer(node.right);
            } else {
                foundNullChild = true; // Right child is missing, flag it
            }
        }
        return true;
    }
}