/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1=headA, temp2=headB;
        int s1=0,s2=0;
        while(temp1!=null){
            temp1=temp1.next;
            s1++;
        }
        while(temp2!=null){
            temp2=temp2.next;
            s2++;
        }
        temp1=headA;
        temp2=headB;
        if(s1>s2){
            for(int i=0;i<s1-s2;i++){
                temp1=temp1.next;
            }
        }
        else{
            for(int i=0;i<s2-s1;i++){
                temp2=temp2.next;
            }
        }
        while(temp1!=null && temp2!=null){
            if(temp1==temp2) return temp1;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return null;
    }
}