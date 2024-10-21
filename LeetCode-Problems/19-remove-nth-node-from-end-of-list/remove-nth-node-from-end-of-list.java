/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        int m = size - n + 1;
        temp = head;
        for (int i = 1; i < m - 1; i++) {
            temp = temp.next;
        }
        //System.out.println(temp.val);
        if(m==1)
            head=head.next;
        else if(size!=1 && temp.next.next!=null)
            temp.next = temp.next.next;
        else if(size==1)
            head=null;
        else
            temp.next=null;
        return head;
    }
}