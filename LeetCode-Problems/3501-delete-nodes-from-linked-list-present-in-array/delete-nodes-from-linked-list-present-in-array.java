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
    public ListNode modifiedList(int[] nums, ListNode head) {
         HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        
        while(head!=null){
             if (!set.contains(head.val)) {
                temp.next =head; 
                temp = temp.next; 
            }
            head = head.next;
        }
        temp.next = null;
        return dummy.next;
    }
}