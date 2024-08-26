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
    public void path(TreeNode root,List<String> list,String s){
        if(root.left==null && root.right==null){
            list.add(s);
            return;
        }
        if(root.left!=null){
            String str1=s+"->"+String.valueOf(root.left.val);
            path(root.left,list,str1);
        }
        if(root.right!=null){
            String str1=s+"->"+String.valueOf(root.right.val);
            path(root.right,list,str1);
        }
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<>();
        String str=String.valueOf(root.val);
        path(root,list,str);
        return list;
    }
}