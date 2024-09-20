class Solution {
    public void order(List<Integer> list,int curr,int n){
        if(curr>n) return;
        list.add(curr);
        
        for(int i=0;i<=9;i++){
            if(10*curr+i>n) return;
            order(list,10*curr+i,n);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=9;i++) order(list,i,n);
        return list;
    }
}