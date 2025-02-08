class NumberContainers {
    private TreeMap<Integer,Integer> map;
     private HashMap<Integer, TreeSet<Integer>> numberMap;
    public NumberContainers() {
        map=new TreeMap<>();
        numberMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(map.containsKey(index)){
            int oldNumber = map.get(index);
            numberMap.get(oldNumber).remove(index);
            if (numberMap.get(oldNumber).isEmpty()) {
                numberMap.remove(oldNumber);
            }
        }
        map.put(index,number);
        numberMap.putIfAbsent(number, new TreeSet<>());
        numberMap.get(number).add(index);
    }
    
    public int find(int number) {
        
        return numberMap.containsKey(number) ? numberMap.get(number).first() : -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */