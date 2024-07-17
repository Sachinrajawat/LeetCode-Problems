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
    public TreeNode deleteNodes(TreeNode root,ArrayList<Integer> arr,List<TreeNode> result){

        if(root==null) return null;
        
        root.left = deleteNodes(root.left, arr, result);
        root.right = deleteNodes(root.right, arr, result);

        if(arr.contains(root.val)){
            if (root.left != null) result.add(root.left);
            if (root.right != null) result.add(root.right);

            return null; 
        }
        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> result=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int del:to_delete) arr.add(del);
        
        root=deleteNodes(root,arr,result);
        if (root != null) result.add(root);
        
        return result;
    }
}