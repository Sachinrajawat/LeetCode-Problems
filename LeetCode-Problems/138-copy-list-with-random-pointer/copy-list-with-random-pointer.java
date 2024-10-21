/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp1=head;
        Node copyHead=new Node(0);
        Node temp2=copyHead;
        //deep copy
        while(temp1!=null){
            Node newHead=new Node(temp1.val);
            temp2.next=newHead;
            temp2=newHead;
            temp1=temp1.next;
        }
        copyHead=copyHead.next;
        temp1=head;
        temp2=copyHead;

        //alternate connections
        Node a=new Node(-1);
        while(temp1!=null || temp2!=null){
            a.next=temp1;
            temp1=temp1.next;
            a=a.next;
            a.next=temp2;
            temp2=temp2.next;
            a=a.next;
        } 
        temp1=head;
        temp2=copyHead;

        //assigning random pointer
        while(temp1!=null){
        if(temp1.random==null) temp2.random=null;
        else temp2.random=temp1.random.next;
        temp1=temp2.next;
        if(temp1!=null) temp2=temp1.next;
        }
        temp1=head;
        temp2=copyHead;
        while(temp1!=null){
            temp1.next=temp2.next;
            temp1=temp2.next;
            if(temp1==null) break;
            temp2.next=temp1.next;
            if(temp2.next==null) break;
            temp2=temp1.next;
        }
        return copyHead;
    }
    
}