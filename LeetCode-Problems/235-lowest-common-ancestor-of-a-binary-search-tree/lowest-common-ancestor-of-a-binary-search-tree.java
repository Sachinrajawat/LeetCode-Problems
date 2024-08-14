/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    ArrayList LCS(TreeNode root,ArrayList<TreeNode> arr,TreeNode target){
        if(root==target){
            arr.add(root);
            return arr;
        }
        else arr.add(root);
        
        if(target.val<root.val) LCS(root.left,arr,target);
        if(target.val>root.val) LCS(root.right,arr,target);
        return arr;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pLCS=new ArrayList<>();
        LCS(root,pLCS,p);
        
        ArrayList<TreeNode> qLCS=new ArrayList<>();
        LCS(root,qLCS,q);

        for(int i=pLCS.size()-1;i>=0;i--){
            for(int j=qLCS.size()-1;j>=0;j--){
                if(pLCS.get(i)==qLCS.get(j)) return pLCS.get(i);
            }
        }
        return root;
    }
}