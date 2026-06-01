class Solution {
    public int minimumCost(int[] cost) {
        int totalCost=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int c:cost) pq.add(c);
        while(pq.size()!=0){
            totalCost+=pq.remove();
            if(pq.size()!=0){
                totalCost+=pq.remove();
            }else return totalCost;
            if(pq.size()!=0){
                pq.remove();
            }
        }
        return totalCost;
    }
}