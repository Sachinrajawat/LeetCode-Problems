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
    public ListNode reverse(ListNode list){
        if(list.next==null) return list;
        ListNode prev=null, temp=list;
        while(temp!=null){
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode revL1=l1;
        ListNode revL2=l2;
        ListNode rev=new ListNode(-1);
        ListNode temp=rev;
        int carry=0;
        while(revL1!=null && revL2!=null){
            int sum=carry+revL1.val+revL2.val;
            if(sum>9){
                carry=1;
                temp.next=new ListNode(sum%10);
                temp=temp.next;
            }
            else{
                carry=0;
                temp.next=new ListNode(sum);
                temp=temp.next;
            }
            revL1=revL1.next;
            revL2=revL2.next;
        }
        while(revL1!=null){
            int sum=carry+revL1.val;
            if(sum>9){
                carry=1;
                temp.next=new ListNode(sum%10);
                temp=temp.next;
            }
            else{
                carry=0;
                temp.next=new ListNode(sum);
                temp=temp.next;
            }
            revL1=revL1.next;
        }
        while(revL2!=null){
            int sum=carry+revL2.val;
            if(sum>9){
                carry=1;
                temp.next=new ListNode(sum%10);
                temp=temp.next;
            }
            else{
                carry=0;
                temp.next=new ListNode(sum);
                temp=temp.next;
            }
            revL2=revL2.next;
        }
        if(carry==1){
            temp.next=new ListNode(1);
            temp=temp.next;
        }
        return rev.next;
    }
}