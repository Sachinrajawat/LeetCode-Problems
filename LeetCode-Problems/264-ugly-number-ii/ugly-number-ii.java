class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        pq.add(1L);
        Set<Long> seen = new HashSet<>();
        seen.add(1L);
        int count=0;
        long ans=0;
        while(count<n){
            ans=pq.poll();
            if(!seen.contains(ans*2)){
                pq.add(ans*2);
                seen.add(ans*2);
            }
            if(!seen.contains(ans*3)){
                pq.add(ans*3);
                seen.add(ans*3);
            }
            if(!seen.contains(ans*5)){
                pq.add(ans*5);
                seen.add(ans*5);
            }
            count++;
        }
        return (int)ans;
    }
}