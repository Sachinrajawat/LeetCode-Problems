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
        ListNode l=new ListNode(0);
        ListNode t=l;
        ListNode t1=l1;
        ListNode t2=l2;
        boolean f=false;
        int x;
        while(t1!=null&&t2!=null){
            if(f==false) x=t1.val+t2.val;
            else x=t1.val+t2.val+1;
            f=false;
            if(x>=10){
                x%=10;
                f=true;
                ListNode a=new ListNode(x);
                t.next=a;
                t=a;
            }
            else{
                ListNode a=new ListNode(x);
                t.next=a;
                t=a;
            }
            t1=t1.next;
            t2=t2.next;
        }
        if(t2==null){
        while(t1!=null){
            if(f==false) x=t1.val;
            else x=t1.val+1;
            f=false;
            if(x>=10){
                x%=10;
                f=true;
                ListNode a=new ListNode(x);
                t.next=a;
                t=a;
            }
            else{
                ListNode a=new ListNode(x);
                t.next=a;
                t=a;
            }
            t1=t1.next;
        }
        }
        if(t1==null){
        while(t2!=null){
            if(f==false) x=t2.val;
            else x=t2.val+1;
            f=false;
            if(x>=10){
                x%=10;
                f=true;
                ListNode a=new ListNode(x);
                t.next=a;
                t=a;
            }
            else{
                ListNode a=new ListNode(x);
                t.next=a;
                t=a;
            }
            t2=t2.next;
        }
        }
        if(f){
            ListNode a=new ListNode(1);
            t.next=a;
        }
        return l.next;
    }
}