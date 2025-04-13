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

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1 || head==null) return head;
        ListNode temp=head;
        ListNode nextNode=null, prevNode=null;
        while(temp!=null){
            ListNode kthNode=findKthNode(temp,k);
            if(kthNode==null){
                prevNode.next=temp;
                break;
            }
            nextNode = kthNode.next;
            kthNode.next=null;
            reverse(temp);
            if(temp==head){
                head=kthNode;
            }else{
                prevNode.next=kthNode;
            }
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }
    public void reverse(ListNode head){
        ListNode prev=null,curr=head,next=null;
        while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
    }
    public ListNode findKthNode(ListNode temp,int k){
        // ListNode tmp=temp;
        while(temp!=null && k>1){
            temp=temp.next;
            k--;
        }
        return temp;
    }
}