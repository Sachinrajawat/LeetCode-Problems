class CustomStack {
    int maxSize=0,size=0;
    ArrayList<Integer> arr;
    public CustomStack(int maxSize) {
        this.maxSize=maxSize;
        arr=new ArrayList<>();
    }
    
    public void push(int x) {
        if(size!=maxSize){
            arr.add(x);
            size++;
        }
    }
    
    public int pop() {
        if(size==0) return -1;
        size--;
        return arr.remove(arr.size()-1);
    }
    
    public void increment(int k, int val) {
        int i=0;
        while(i<arr.size() &&i<k){
            arr.set(i,arr.get(i)+val);
            i++;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */