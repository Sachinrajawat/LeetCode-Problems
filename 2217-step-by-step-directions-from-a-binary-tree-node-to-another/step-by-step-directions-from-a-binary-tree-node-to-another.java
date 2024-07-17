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
     public boolean findPath(TreeNode root, int value, StringBuilder path) {
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            return true;
        }
        path.append('L');
        if (findPath(root.left, value, path)) {
            return true;
        }
        path.setLength(path.length() - 1);
        path.append('R');
        if (findPath(root.right, value, path)) {
            return true;
        }
        path.setLength(path.length() - 1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int src, int dest) {
        if (root == null) {
            return null;
        }
        if (root.val == src || root.val == dest) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, src, dest);
        TreeNode right = lowestCommonAncestor(root.right, src, dest);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode ancestor = lowestCommonAncestor(root, startValue, destValue);
        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();

        findPath(ancestor, startValue, startPath);
        findPath(ancestor, destValue, destPath);

        // Find the divergence point
        int i = 0;
        while (i < startPath.length() && i < destPath.length() && startPath.charAt(i) == destPath.charAt(i)) {
            i++;
        }

        // Construct the result based on the remaining paths
        StringBuilder result = new StringBuilder();
        
        // Add 'U' for each step in the remaining startPath
        for (int j = i; j < startPath.length(); j++) {
            result.append('U');
        }
        
        // Append the remaining destPath from the divergence point
        result.append(destPath.substring(i));

        return result.toString();
    }
}