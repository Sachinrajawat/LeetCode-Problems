class ProductOfNumbers {
    ArrayList<Integer> arr;
    int prod;
    public ProductOfNumbers() {
        arr=new ArrayList<>();
        prod=1;
    }
    
    public void add(int num) {
        
        if(num==0){
            arr.clear();
            prod=1;
        }
        else{
            prod*=num;
            arr.add(prod);
        }
    }
    
    public int getProduct(int k) {
        int n=arr.size();
        if (k > n) return 0;
        if(k==n) return arr.get(n-1);
        return arr.get(n-1)/arr.get(n-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */