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
    
    public int find(int[] inorder,int target,int start,int end){
        for(int i=start;i<=end;i++){
            if(inorder[i]==target) return i;
        }
        return -1;
    }
    public TreeNode Tree(int[] inorder,int[] preorder,int InStart,int InEnd,int[] preIndex){
        if(InStart>InEnd) return null;
        TreeNode root=new TreeNode(preorder[preIndex[0]]);
        preIndex[0]++;
        int pos= find(inorder,root.val,InStart,InEnd);
        root.left=Tree(inorder,preorder,InStart,pos-1,preIndex);
        root.right=Tree(inorder,preorder,pos+1,InEnd,preIndex);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preIndex = {0};
       
        
        return Tree(inorder,preorder,0,inorder.length-1,preIndex);
    }
}