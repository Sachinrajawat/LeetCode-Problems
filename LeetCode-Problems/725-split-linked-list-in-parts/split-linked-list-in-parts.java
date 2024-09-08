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
        arr[0]=head;
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int[] ar=new int[k];
        int x=count/k;
        for(int i=0;i<k;i++){
            ar[i]=x;
        }
        int y=count%k;
        int j=0;
        while(y>0){
            ar[j++]+=1;
            y--;
        }
        for(int i:ar) System.out.print(i+" ");
        temp=head;
        for(int i=0;i<k;i++){
            ListNode prev=null;
            arr[i]=temp;
            if(ar[i]==0) arr[i]=prev;
            else{
            while(ar[i]>0){
                prev=temp;
                temp=temp.next;
                ar[i]--;
                }
                prev.next=null;
            }
        }
        // System.out.println(count);
        return arr;
    }
}