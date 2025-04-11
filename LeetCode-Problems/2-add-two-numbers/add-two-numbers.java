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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rev=new ListNode(-1);
        ListNode temp=rev;
        int carry=0;
        while(l1!=null && l2!=null){
            int sum=carry+l1.val+l2.val;
            if(sum>9){
                carry=1;
                temp.next=new ListNode(sum%10);
            }
            else{
                carry=0;
                temp.next=new ListNode(sum);
            }
            temp=temp.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int sum=carry+l1.val;
            if(sum>9){
                carry=1;
                temp.next=new ListNode(sum%10);
            }
            else{
                carry=0;
                temp.next=new ListNode(sum);
            }
            temp=temp.next;
            l1=l1.next;
        }
        while(l2!=null){
            int sum=carry+l2.val;
            if(sum>9){
                carry=1;
                temp.next=new ListNode(sum%10);
            }
            else{
                carry=0;
                temp.next=new ListNode(sum);
            }
            temp=temp.next;
            l2=l2.next;
        }
        if(carry==1){
            temp.next=new ListNode(1);
            temp=temp.next;
        }
        return rev.next;
    }
}