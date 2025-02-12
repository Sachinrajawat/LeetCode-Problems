class Solution {
    public int sum(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        int ans=-1;
        Map<Integer,PriorityQueue<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int s=sum(nums[i]);
            if(map.containsKey(s)){
                PriorityQueue<Integer> pq=map.get(s);
                pq.add(nums[i]);
                map.put(s,pq);
            }
            else{
                PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
                pq.add(nums[i]);
                map.put(s,pq);
            }
        }
        for(var key:map.keySet()){
            PriorityQueue<Integer> pq=map.get(key);
            if(pq.size()>=2){
                int a=pq.remove();
                int b=pq.remove();
                ans=Math.max(ans,a+b);
            }
        }
        return ans;
    }
}