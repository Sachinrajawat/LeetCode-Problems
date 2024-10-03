class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
           sum=(sum+nums[i])%p; 
        }
        // if(sum<p) return -1;
        sum%=p;
        if(sum==0) return 0;
        
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int curr=0;
        int count=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            
            curr=(curr+nums[i])%p;
            if(map.containsKey((curr-sum+p)%p)){
                int j=map.get((curr-sum+p)%p);
                count=Math.min(count,i-j);
            }
            map.put(curr%p,i);
        }
        return count==n?-1:count;
    }
}