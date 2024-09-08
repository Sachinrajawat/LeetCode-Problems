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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] arr=new ListNode[k];
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int[] size=new int[k]; //size of each list
        int y=count%k;
        for(int i=0;i<k;i++){
            size[i]=count/k;
            if(y>0){
                size[i]+=1;
                y--;
            }
        }
        
        temp=head;
        for(int i=0;i<k;i++){
            arr[i]=temp;
            if(size[i]>0){
                ListNode prev=null;
                while(size[i]>0){
                    prev=temp;
                    temp=temp.next;
                    size[i]--;
                    }
                    prev.next=null;
                }
            }
        return arr;
    }
}