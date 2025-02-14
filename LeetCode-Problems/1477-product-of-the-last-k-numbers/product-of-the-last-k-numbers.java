class ProductOfNumbers {
    // HashMap<Integer, Integer> map;
    // int idx;
    // int sum;
    ArrayList<Integer> arr;
    public ProductOfNumbers() {
        // map=new HashMap<>();
        // idx=1;
        // sum=1;
        arr=new ArrayList<>();
    }
    
    public void add(int num) {
        // sum*=num;
        // map.put(idx,sum);
        // idx++;
        arr.add(num);
    }
    
    public int getProduct(int k) {
        int prod=1;
        for(int i=arr.size()-1;i>=arr.size()-k;i--){
            prod*=arr.get(i);
        }
        return prod;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */