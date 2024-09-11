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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<lists.length;i++){
            ListNode head=lists[i];
            while(head!=null){
                pq.add(head.val);
                head=head.next;
            }
        }
        if(pq.size()==0) return null;
        ListNode l=new ListNode(pq.poll());
        ListNode temp=l;
        while(!pq.isEmpty()){
            temp.next=new ListNode(pq.poll());
            temp=temp.next;
        }
        return l;
    }
}