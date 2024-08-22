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
    public HashMap<Integer, ArrayList<ArrayList<Integer>>> pathSum(TreeNode root,HashMap<Integer, ArrayList<ArrayList<Integer>>> map,ArrayList<Integer> arr,int sum){
        if(root.left==null &&root.right==null){
            if(map.containsKey(sum)){
                ArrayList<ArrayList<Integer>> a=map.get(sum);
                a.add(arr);
                map.put(sum,a);
            }
            else{
                ArrayList<ArrayList<Integer>> newPathList = new ArrayList<>();
                newPathList.add(arr);
                map.put(sum, newPathList);
            }
            
            return map;
        }
        
        if(root.left!=null && root.right!=null){
            ArrayList<Integer> aL= new ArrayList<>(arr);
            aL.add(root.left.val);
            System.out.println(aL);
            pathSum(root.left,map,aL,sum+root.left.val);
            ArrayList<Integer> aR= new ArrayList<>(arr);
            aR.add(root.right.val);
            System.out.println(aR);
            pathSum(root.right,map,aR,sum+root.right.val);
        }
        else if(root.left!=null || root.right!=null){
            if(root.left!=null){
                arr.add(root.left.val);
                System.out.println(arr);
                pathSum(root.left,map,arr,sum+root.left.val);
            }
            else if(root.right!=null){
                arr.add(root.right.val);
                System.out.println(arr);
                pathSum(root.right,map,arr,sum+root.right.val);
            }
        }
        return map;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        HashMap<Integer,ArrayList<ArrayList<Integer>>> map=new HashMap<>();
        // ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(root.val);
        // arr.add(a);
        pathSum(root,map,arr,root.val);
        System.out.println(map);
        if(!map.containsKey(targetSum)) return ans;
        else{
            for(var key:map.keySet()){
                if(key==targetSum){
                    ArrayList<ArrayList<Integer>> array= map.get(key);
                    for(int i=0;i<array.size();i++){
                        ans.add(array.get(i));
                    }
                }
            }
        }
        
        return ans;
    }
}