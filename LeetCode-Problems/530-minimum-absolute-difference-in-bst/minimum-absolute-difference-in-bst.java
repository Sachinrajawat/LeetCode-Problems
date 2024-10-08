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
    public ArrayList inOrder(TreeNode root,ArrayList<Integer> arr){
        if(root==null) return arr;
        inOrder(root.left,arr);
        arr.add(root.val);
        inOrder(root.right,arr);
        return arr;
    }
    public int getMinimumDifference(TreeNode root) {
         ArrayList<Integer> arr=new ArrayList<>();
        inOrder(root,arr);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<arr.size();i++){
            min=Math.min(min,arr.get(i)-arr.get(i-1));
        }
        return min;
    }
}