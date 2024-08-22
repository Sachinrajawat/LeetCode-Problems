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
    public ArrayList pathSum(TreeNode root,ArrayList<Integer> arr,int sum){
        if(root.left==null &root.right==null){
            arr.add(sum);
            return arr;
        }
        if(root.left!=null) pathSum(root.left,arr,sum+root.left.val);
        if(root.right!=null) pathSum(root.right,arr,sum+root.right.val);
        return arr;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        ArrayList<Integer> arr=new ArrayList<>();
        pathSum(root,arr,root.val);
        if(!arr.contains(targetSum)) return false;
        return true;
    }
}