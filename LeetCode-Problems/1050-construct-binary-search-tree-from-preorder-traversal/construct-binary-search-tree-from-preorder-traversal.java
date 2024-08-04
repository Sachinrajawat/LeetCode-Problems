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
    public TreeNode bst(int[] preorder,int start,int end){
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[start]);
        int i;
        for(i=start+1;i<=end;i++){
            if(preorder[start]<preorder[i]){
                break;
            }
        }
        root.left=bst(preorder,start+1,i-1);
        root.right=bst(preorder,i,end);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder,0,preorder.length-1);
    }
}