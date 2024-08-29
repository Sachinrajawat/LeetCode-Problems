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
    public int sum(HashMap<Integer,Integer> map,TreeNode root){
        if(root==null) return 0;
        int sum=root.val+sum(map,root.left)+sum(map,root.right);
        map.put(sum,map.getOrDefault(sum,0)+1);
        return sum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer,Integer> map=new HashMap<>();
        sum(map,root);
        int maxFreq=1,count=0;
        for(var key:map.keySet()){
            if(maxFreq==map.get(key)) count++;
            if(maxFreq<map.get(key)){
            maxFreq=map.get(key);
            count=1;
           }
        }
        int[] arr=new int[count];
        int i=0;
        for(var key:map.keySet()){
            if(maxFreq==map.get(key)){
                arr[i++]=key;
            }
        }
        return arr;
    }
}