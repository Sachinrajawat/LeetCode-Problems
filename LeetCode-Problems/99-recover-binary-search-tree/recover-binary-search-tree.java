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
    public ArrayList inorder(TreeNode root,ArrayList<Integer> arr){
        if(root==null) return arr;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
        return arr;
    }
    public void recover(TreeNode root,int first,int sec,boolean f,boolean s){
        if(f&&s) return;
        if(!f && root.val==first){
            root.val=sec;
            f=true;
        }
        else if(!s && root.val==sec){
            root.val=first;
            s=true;
        }
        if(root.left!=null) recover(root.left,first,sec,f,s);
        if(root.right!=null) recover(root.right,first,sec,f,s);
    }
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        int first=0,sec=0;
        boolean x=true;
        for(int i=0;i<arr.size()-1;i++){
            if(arr.get(i)>arr.get(i+1)){
                first=arr.get(i+1);
                if(x){
                    sec=arr.get(i);
                    x=false;
                }
                // break;
            }
        }
    System.out.println(first+" "+sec);
        System.out.println(arr);
        recover(root,first,sec,false,false);
    }
}