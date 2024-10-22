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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        long sum=0;
        PriorityQueue<Long> pq=new PriorityQueue<>(Collections.reverseOrder());
        Queue<TreeNode> temp=new LinkedList<>();
        while(!q.isEmpty()){
            TreeNode t=q.remove();
            sum+=t.val;
            if(t.left!=null) temp.add(t.left);
            if(t.right!=null) temp.add(t.right);
            if(q.isEmpty()){
                q=temp;
                temp=new LinkedList<>();
                pq.add(sum);
                sum=0;
            }
        }
        if(k>pq.size()) return -1;
        int j=0;
        while(j++<k-1) pq.remove();
        return pq.remove();
    }
}