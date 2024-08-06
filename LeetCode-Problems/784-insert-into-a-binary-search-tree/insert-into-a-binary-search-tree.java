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
    // ArrayList preorder(TreeNode root,ArrayList<Integer> arr){
    //     if(root==null) return arr;
    //     arr.add(root.val);
    //     if(root.left!=null) preorder(root.left,arr);
    //     if(root.right!=null) preorder(root.right,arr);
    //     return arr;
    // }
    // ArrayList insert(ArrayList<Integer> arr,int start,int end,int val){
    //     if(start==end){
    //         if(val<arr.get(start)){
    //             arr.add(start,val);
    //             return arr;
    //         }
    //         else{
    //             arr.add(start+1,val);
    //             return arr;
    //         }
    //     }
    //     int i;
    //     for(i=start+1;i<=end;i++){
    //         if(arr.get(start)<arr.get(i)) break;
    //     }
    //     if(val<arr.get(start)) insert(arr,start+1,i-1,val);
    //     if(val>arr.get(start)) insert(arr,i,end,val);
    //     return arr;
    // }
    // TreeNode Bst(ArrayList<Integer> arr,int start,int end){
    //     if(start>end) return null;
    //     int i;
    //     TreeNode root=new TreeNode(arr.get(start));
    //     for(i=start+1;i<=end;i++){
    //         if(arr.get(start)<arr.get(i)){
    //             break;
    //         }
    //     }
    //     root.left=Bst(arr,start+1,i-1);
    //     root.right=Bst(arr,i,end);
    //     return root;
    // }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // ArrayList<Integer> arr=new ArrayList<>();
        // preorder(root,arr);
        // insert(arr,0,arr.size()-1,val);
        // return  Bst(arr,0,arr.size()-1);
        if (root == null) {
            return new TreeNode(val);
        }
        
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        
        return root;
    }
}