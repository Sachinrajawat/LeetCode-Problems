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
    public int find(int[] inorder,int start,int end,int target){
        for(int i=start;i>=end;i--){
            if(inorder[i]==target) return i;
        }
        return -1;
    }
    TreeNode Tree(int[] inorder,int[] postorder,int start,int end,int[] index){
        if(start<end) return null;
        TreeNode node=new TreeNode(postorder[index[0]]);
        index[0]--;
        int pos=find(inorder,start,end,node.val);
        node.right=Tree(inorder,postorder,start,pos+1,index);
        node.left=Tree(inorder,postorder,pos-1,end,index);
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] index={inorder.length-1};
        return Tree(inorder,postorder,inorder.length-1,0,index);
    }
}