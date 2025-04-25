class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n=nums.size();
        long ans=0, sum=0;
        Map<Integer,Long> map=new HashMap<>();
        map.put(0,1L);
        for(int i=0;i<n;i++){
            if(nums.get(i) % modulo == k) {
                sum += 1;
            }
            int r1=(int)sum%modulo;
            int r2=(r1-k+modulo)%modulo;
            ans+=map.getOrDefault(r2,0L);
            map.put(r1,map.getOrDefault(r1,0L)+1);
        }
        return ans;

    }
}