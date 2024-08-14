/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode inorder(ListNode head,int start,int end){
        if(start>end) return null; 
        int mid=start+(end-start)/2;
        if((end-start)%2!=0) mid++;
        TreeNode node=new TreeNode();
        int i=0;
        ListNode temp=head;
        while(i<=mid){
            if(i==mid) node=new TreeNode(temp.val);
            temp=temp.next;
            i++;
        }
        node.left=inorder(head,start,mid-1);
        node.right=inorder(head,mid+1,end);
        return node;
    }
    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        TreeNode node=inorder(head,0,size-1);
        return node;
    }
}