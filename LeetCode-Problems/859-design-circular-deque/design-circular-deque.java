class MyCircularDeque {
    int size=0;
    class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    int maxSize=0;
    Node head;
    public MyCircularDeque(int k) {
        head=new Node(0);
        maxSize=k;
    }
    
    public boolean insertFront(int value) {
        if(size==maxSize) return false;
        Node temp=new Node(value);
        Node headNext=head.next;
        head.next=temp;
        temp.next=headNext;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size==maxSize) return false;
        Node temp=new Node(value);
        Node t=head;
        while(t.next!=null){
            t=t.next;
        }
        t.next=temp;
        temp.next=null;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(size==0) return false;
        head=head.next;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(size==0) return false;
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        size--;
        return true;
    }
    
    public int getFront() {
        if(size==0) return -1;
        return head.next.data;
    }
    
    public int getRear() {
        if(size==0) return -1;
        Node temp=head.next;
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp.data;
    }
    
    public boolean isEmpty() {
        if(size==0) return true;
         return false;
    }
    
    public boolean isFull() {
        if(size==maxSize) return true;
         return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */