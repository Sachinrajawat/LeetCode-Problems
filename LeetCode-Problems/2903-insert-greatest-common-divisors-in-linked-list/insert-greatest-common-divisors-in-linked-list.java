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
    public int gcd(int a,int b){
            if(b==0) return a;
            return gcd(b,a%b);
        }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next==null) return head;
        ListNode curr=head;
        while(curr.next!=null){
            int Gcd=gcd(curr.val,curr.next.val);
            ListNode temp=curr.next;
            curr.next=new ListNode(Gcd);
            curr.next.next=temp;
            curr=temp;
        }
        return head;
    }
}