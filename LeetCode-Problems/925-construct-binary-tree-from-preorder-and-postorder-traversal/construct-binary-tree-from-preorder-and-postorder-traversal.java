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
    
    public TreeNode construct(int[] preorder,int preStart,int preEnd,int[] postorder,int posStart){
        if(preStart>preEnd) return null;
        TreeNode root=new TreeNode(preorder[preStart]);
        if(preStart==preEnd) return root;
        int nextNode=preorder[preStart+1];
        int j=posStart;
        while(postorder[j]!=nextNode) j++;
        int num=j-posStart+1;
        root.left=construct(preorder,preStart+1, preStart+num,postorder,posStart);
        root.right=construct(preorder,preStart+num+1, preEnd,postorder,j+1);
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return construct(preorder,0,preorder.length-1,postorder,0);
    }
}