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
            String str=String.valueOf(root.val);
            s+=str;
            list.add(s);
            return;
        }
        String str=String.valueOf(root.val)+"->";
        if(root.left!=null){
            
            path(root.left,list,s+str);
        }
        if(root.right!=null){
            path(root.right,list,s+str);
        }
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<>();
        // String str=String.valueOf(root.val);
        path(root,list,"");
        return list;
    }
}