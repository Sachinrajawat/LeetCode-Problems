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
    ArrayList preorder(TreeNode root,ArrayList<Integer> arr,int key){
        if(root==null) return arr;
        if(root.val!=key) arr.add(root.val);
        if(root.left!=null) preorder(root.left,arr,key);
        if(root.right!=null) preorder(root.right,arr,key);
        return arr;
    }
    TreeNode Bst(ArrayList<Integer> arr,int start,int end){
        if(start>end) return null;
        int i;
        TreeNode root=new TreeNode(arr.get(start));
        for(i=start+1;i<=end;i++){
            if(arr.get(start)<arr.get(i)){
                break;
            }
        }
        root.left=Bst(arr,start+1,i-1);
        root.right=Bst(arr,i,end);
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        ArrayList<Integer> arr=new ArrayList<>();
        preorder(root,arr,key);
        System.out.println(arr);
        return Bst(arr,0,arr.size()-1);
    }
}