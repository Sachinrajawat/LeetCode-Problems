class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int num:nums){
            pq.add((long)num);
        }
        int c=0;
        while(pq.peek()<k){
            long a=pq.poll();
            long b=pq.poll();
            pq.add(Math.min(a,b)*2+Math.max(a,b));
            c++;
        }
        return c;
    }
}