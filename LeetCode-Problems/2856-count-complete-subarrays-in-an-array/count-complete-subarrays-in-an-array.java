class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int size=set.size();
        int count=0;
        for(int i=0;i<=nums.length-size;i++){
            Set<Integer> s=new HashSet<>();
            for(int j=i;j<nums.length;j++){
                s.add(nums[j]);
                if(s.size()>=size) count++;
            }
        }
        return count;
    }
}