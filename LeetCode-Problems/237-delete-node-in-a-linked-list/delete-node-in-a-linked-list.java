/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode nextNode=node;
        while(nextNode.next!=null){
            node.val=nextNode.next.val;
            nextNode=nextNode.next;
            if(nextNode.next==null){
                node.next=null;
                break;
            }
            node=node.next;
        }
    }
}