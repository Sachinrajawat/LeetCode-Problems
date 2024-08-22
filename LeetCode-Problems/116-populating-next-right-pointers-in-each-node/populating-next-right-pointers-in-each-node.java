/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        Queue<Node> q1=new LinkedList<>();
        Queue<Node> q2=new LinkedList<>();
        q1.add(root);
        while (!q1.isEmpty()) {
            Node temp2 = null; // Initialize temp2 as null for each level

            while (!q1.isEmpty()) {
                Node node = q1.remove();
                
                // If temp2 is not null, set its next pointer to the current node
                if (temp2 != null) {
                    temp2.next = node;
                }
                
                temp2 = node; // Move temp2 to the current node
                
                // Add children to q2 for the next level
                if (node.left != null) q2.add(node.left);
                if (node.right != null) q2.add(node.right);
            }

            // End of level, set the last node's next to null
            temp2.next = null;

            // Swap queues
            q1 = q2;
            q2 = new LinkedList<>();
        }
        return root;
    }
}