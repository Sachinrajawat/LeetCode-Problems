/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public void traverse(Node root,List<Integer> list){
        if(root==null) return;
        List<Node> l=root.children;
        for(int i=0;i<l.size();i++) traverse(l.get(i),list);
        list.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        traverse(root,ans);
        return ans;
    }
}