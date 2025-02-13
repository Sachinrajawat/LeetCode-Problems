class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq=new PriorityQueue<>(Collections.reverseOrder());
        double sum=0;
        for(int num:nums){
            sum+=num;
            pq.add((double)num);
        }
        int c=0;
        double x=sum;
        while(x>sum/2){
            double p=pq.poll();
            x-=p;
            p/=2;
            x+=p;
            pq.add(p);
            c++;
        }
        return c;
    }
}