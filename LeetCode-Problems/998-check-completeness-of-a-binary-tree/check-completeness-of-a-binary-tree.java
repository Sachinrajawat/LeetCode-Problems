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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> st=new LinkedList<>();
        st.offer(root);
        boolean r=false;
        while(st.size()!=0){
            TreeNode node=st.poll();
            System.out.println(node.val);
            if(node.left!=null && r) return false;
            if(node.left==null && node.right!=null) return false;
            else if(node.left!=null && node.right==null) r=true;
            else if(node.left==null && node.right==null) r=true;
            if(node.left!=null){
                st.offer(node.left);
            }
            if(node.right!=null){
                st.offer(node.right);
            }
            System.out.println(st);
        }
        return true;
    }
}