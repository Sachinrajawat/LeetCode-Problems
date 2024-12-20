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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        Queue<TreeNode> temp=new LinkedList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        int count =0,i=0;
        while(!q.isEmpty()){
            TreeNode t=q.remove();
            // if(t!=null) System.out.println(t.val);
            if(count%2!=0) t.val=arr.get(i++);
            if(t.left!=null){
                temp.add(t.left);
                if(count%2==0) arr.add(t.left.val);
            }
            if(t.right!=null){
                temp.add(t.right);
                if(count%2==0){
                    arr.add(t.right.val);
                }
            }
            if(q.isEmpty()){
                System.out.println(arr);
                q=temp;
                temp=new LinkedList<>();
                if(count%2==0){
                    Collections.reverse(arr);
                }
                else{
                    arr=new ArrayList<>();
                    i=0;
                }
            count++;
            }
        }
        return root;
    }
}