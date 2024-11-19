class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int size=0;
        long sum=0,ans=0;
        int j=0;
        while(j<nums.length){
            if(size==k){
                map.remove(nums[j-k]);
            sum-=nums[j-k];
            size--;
            }
            if(!map.containsKey(nums[j])){
                map.put(nums[j],j);
                sum+=nums[j];
                size++;
                if (size == k)
                ans=Math.max(sum,ans);
                j++;
            }
            else{
                j=map.get(nums[j])+1;
                map=new HashMap<>();
                sum=0;
                size=0;
            }
        }
        return ans;
    }
}