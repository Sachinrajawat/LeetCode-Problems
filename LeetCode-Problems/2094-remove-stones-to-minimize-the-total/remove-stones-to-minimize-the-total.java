class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int sum=0;
        for(int pile:piles){
            pq.add(pile);
            sum+=pile;
        }
        while(!pq.isEmpty() && k>0){
            int p=pq.poll();
            sum-=p;
            p-=Math.floor(p/2);
            sum+=p;
            pq.add(p);
            k--;
        }
        return sum;
    }
}