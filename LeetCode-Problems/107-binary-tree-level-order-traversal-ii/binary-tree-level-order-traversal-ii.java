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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        Queue<TreeNode> q1=new LinkedList<>();
        q1.add(root);
        Queue<TreeNode> q2=new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
        List<Integer> arr=new ArrayList<>();
        while(!q1.isEmpty()){
            TreeNode node=q1.remove();
            arr.add(node.val);
            if(node.left!=null) q2.add(node.left);
            if(node.right!=null) q2.add(node.right);
            if(q1.isEmpty()){
                list.add(0,arr);
                arr=new ArrayList<>();
                q1=q2;
                q2=new LinkedList<>();
            }
        }
        return list;
    }
}