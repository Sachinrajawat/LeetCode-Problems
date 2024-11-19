class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int i=0;
        long sum=0,ans=0,size=0;
        while(i<nums.length && size<k){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
                sum+=nums[i];
                size++;
                i++;
            }
            else{
                i=map.get(nums[i])+1;
                map=new HashMap<>();
                sum=0;
                size=0;
            }
        }
        ans=sum;
        if(map.size()!=k) return 0;
        System.out.println(map+" "+i+" "+sum);
        int j=i;
        while(j<nums.length){
            if(size==k){map.remove(nums[j-k]);
            sum-=nums[j-k];
            size--;
            }
            if(!map.containsKey(nums[j])){
                map.put(nums[j],j);
                sum+=nums[j];
                size++;
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
        // System.out.println(set+" "+i+" "+sum);
        return ans;
    }
}