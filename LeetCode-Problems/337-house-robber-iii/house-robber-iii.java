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
    public int solve(TreeNode root,HashMap<TreeNode,Integer> memo){
        if(root==null){
            return 0;
        }
        if (memo.containsKey(root)) return memo.get(root);
        int notTake=solve(root.left,memo)+solve(root.right,memo);
        // int take=root.val+Math.max(Math.max(solve(root.right.left),solve(root.right.right)),Math.max(solve(root.left.left),solve(root.left.right)));
        int take=root.val;
        if(root.left!=null){
            take+=solve(root.left.left,memo)+solve(root.left.right,memo);
        }
        if(root.right!=null){
            take+=solve(root.right.left,memo)+solve(root.right.right,memo);
        }
        int result=Math.max(notTake,take);   
        memo.put(root,result);
        return result; 
    }
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> memo=new HashMap<>();

        return solve(root,memo);
    }
}