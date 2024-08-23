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
    public ArrayList<ArrayList<Integer>> path(TreeNode root,ArrayList<ArrayList<Integer>> list,ArrayList<Integer> arr){
        if(root.left==null &&root.right==null){
            list.add(arr);
            
            return list;
        }
        
        if(root.left!=null && root.right!=null){
            ArrayList<Integer> aL= new ArrayList<>(arr);
            aL.add(root.left.val);
            path(root.left,list,aL);
            ArrayList<Integer> aR= new ArrayList<>(arr);
            aR.add(root.right.val);
            path(root.right,list,aR);
        }
        else if(root.left!=null || root.right!=null){
            if(root.left!=null){
                arr.add(root.left.val);
                path(root.left,list,arr);
            }
            else if(root.right!=null){
                arr.add(root.right.val);
                path(root.right,list,arr);
            }
        }
        return list;
    }
    public int sumNumbers(TreeNode root) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(root.val);
        path(root,list,arr);
        System.out.println(list);
        int sum=0;
        for(int i=0;i<list.size();i++){
            ArrayList<Integer> a=list.get(i);
            int pathSum=0;
            int n=a.size()-1;
            for(int j=0;j<a.size();j++){
                pathSum+=a.get(j)*(int)Math.pow(10,n-j);
            }
            sum+=pathSum;
        }
        return sum;
    }
}