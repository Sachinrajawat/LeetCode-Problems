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
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        Queue<TreeNode> temp=new LinkedList<>();
        List<Integer> arr=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            TreeNode node=q.remove();
            max=Math.max(max,node.val);
            if(node.left!=null) temp.add(node.left);
            if(node.right!=null) temp.add(node.right);
            if(q.isEmpty()){
                arr.add(max);
                max=Integer.MIN_VALUE;
                q=temp;
                temp=new LinkedList<>();
            }
        }
        return arr;
    }
}