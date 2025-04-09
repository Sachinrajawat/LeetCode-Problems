class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q=new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        Queue<Integer> temp=new LinkedList<>();
        while(q.size()>1){
            temp.add(q.remove());
        }
        int pop=q.remove();
        q=new LinkedList<>(temp);
        return pop;
    }
    
    public int top() {
        Queue<Integer> temp=new LinkedList<>();
        while(q.size()>1){
            temp.add(q.remove());
        }
        int pop=q.remove();
        q=new LinkedList<>(temp);
        q.add(pop);
        return pop;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */