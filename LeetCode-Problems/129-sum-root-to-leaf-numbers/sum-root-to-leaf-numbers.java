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
    public void solve(TreeNode root,String curr,int[] arr){
        
        if(root.left==null && root.right==null){
            String s=String.valueOf(root.val);
            curr+=s;
            arr[0]+=Integer.parseInt(curr);
            return;
        }
        String s=String.valueOf(root.val);
        if(root.left!=null) solve(root.left,curr+s,arr);
        if(root.right!=null) solve(root.right,curr+s,arr);
    }
    public int sumNumbers(TreeNode root) {
        int[] arr={0};
        solve(root,"",arr);
        return arr[0];
    }
}