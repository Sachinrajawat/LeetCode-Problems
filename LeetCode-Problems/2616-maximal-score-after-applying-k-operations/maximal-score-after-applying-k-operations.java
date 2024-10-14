class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        long sum=0;
        while(k>0){
            int x=pq.poll();
            System.out.println(x+" ");
            sum+=x;
            pq.add((int)Math.ceil((double)x/3));
            k--;
        }
        return sum;
    }
}