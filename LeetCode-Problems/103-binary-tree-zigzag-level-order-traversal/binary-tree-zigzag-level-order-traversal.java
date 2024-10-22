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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean odd=true;
        while(!q.isEmpty()){
        LinkedList<Integer> list=new LinkedList<>();
        int size=q.size();
        for(int i=0;i<size;i++){
            if(odd){
                TreeNode node=q.pollFirst();
                list.add(node.val);
                if(node.left!=null) q.addLast((node.left));
                if(node.right!=null) q.addLast((node.right));
                
            }
            else{
                TreeNode node=q.pollLast();
                list.add(node.val);
                if(node.right!=null) q.addFirst((node.right));
                if(node.left!=null) q.addFirst((node.left));
            }
        }
        ans.add(list);
        odd=!odd;
        }
        return ans;
    }
}