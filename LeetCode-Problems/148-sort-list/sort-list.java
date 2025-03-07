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
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null) return null;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        ListNode temp=head;
        while(temp!=null){
            pq.add(temp.val);
            temp=temp.next;
        }
        ListNode l=new ListNode(pq.poll());
        temp=l;
        while(!pq.isEmpty()){
            l.next=new ListNode(pq.poll());
            l=l.next;
        }
        return temp;
    }
}