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
    private int i= 0;
    public TreeNode solve(String traversal, int depth){
        if(i>=traversal.length()) return null;
        int j=i;
        while(j<traversal.length() && traversal.charAt(j)=='-'){
            j++;
        }
        int dash = j-i;
        
        if(dash!=depth){
            return null;
        }
        i+=dash;

        int num=0;
        while(i<traversal.length() && Character.isDigit(traversal.charAt(i))){
            num=num*10+(traversal.charAt(i)-'0');
            i++;
        }
        TreeNode root=new TreeNode(num);
        root.left=solve(traversal, depth+1);
        root.right=solve(traversal, depth+1);
        return root;
    }
    public TreeNode recoverFromPreorder(String traversal) {
        return solve(traversal, 0);
    }
}