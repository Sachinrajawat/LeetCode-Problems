class MinStack {
    PriorityQueue<Integer> pq;
    int size;
    int[] arr;
    public MinStack() {
        arr=new int[30000];
        size=0;
        pq=new PriorityQueue<>();
    }
    
    public void push(int val) {
        pq.add(val);
        arr[size]=val;
        size++;
    }
    
    public void pop() {
        int removed = arr[size - 1];
        pq.remove(removed);
        size--;
    }
    
    public int top() {
        return arr[size-1];
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */