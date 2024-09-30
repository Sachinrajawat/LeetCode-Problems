class AllOne {
    class Node{
        int count;
        ArrayList<String> keys;
        Node next;
        Node prev;
        Node(int c){
            count=c;
            prev=null;
            next=null;
            keys=new ArrayList<>();
        }
    }
    HashMap<String,Node> mp;
    Node head;
    // Node first   min key string
    Node last;
    public AllOne() {
        head=new Node(0);
        last=head;
        mp=new HashMap<>();
    }
    void addNode(Node prevNode,int count){
        Node newNode =new Node(count);
        newNode.next=prevNode.next;
        newNode.prev = prevNode;
        if(newNode.next!=null){
            newNode.next.prev=newNode;
        }
        prevNode.next=newNode;
        if(prevNode==last){
            last=newNode;
        }
    }
    void removeNode(Node node){
        node.prev.next=node.next;
        if(node.next!=null){
            node.next.prev=node.prev;
        }
        if(last==node){
            last=node.prev;
        }
        node.prev=null;
        node.next=null;
    }
    
    public void inc(String key) {
        if(!mp.containsKey(key)){
            //nor exists
            //check if there is already a node with count =1
            if(head.next==null || head.next.count!=1){
                addNode(head,1);
            }
            head.next.keys.add(key);
            mp.put(key,head.next);
        }
        else{
            //increase it frequency  -> move to +1 freq node
            Node currNode=mp.get(key);
            int currCount=currNode.count;
            if(currNode.next==null || currNode.next.count!=currCount+1){
                addNode(currNode,currCount+1);
            }
            currNode.next.keys.add(key);
            mp.put(key,currNode.next);
            currNode.keys.remove(key);
            if(currNode.keys.isEmpty()){
                removeNode(currNode);
            }
        }
    }
    
    public void dec(String key) {
        Node currNode=mp.get(key);
        int currCount=currNode.count;

        //Remove the key if count becomes zero
        if(currCount==1){
            mp.remove(key);
        }else{
            if(currNode.prev.count!=currCount-1){
                addNode(currNode.prev,currCount-1);
            }
            currNode.prev.keys.add(key);
            mp.put(key,currNode.prev);
        }
        currNode.keys.remove(key);
        if(currNode.keys.isEmpty()){
            removeNode(currNode);
        }
    }
    
    public String getMaxKey() {
        if(last==head) return "";
        return last.keys.get(0);
    }
    
    public String getMinKey() {
        if(head.next==null) return "";
        return head.next.keys.get(0);
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */