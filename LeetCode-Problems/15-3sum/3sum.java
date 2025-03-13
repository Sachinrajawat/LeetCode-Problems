class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set=new HashSet<>();
        for(int i=2;i<nums.length;i++){
            int target=-nums[i];
            int st=0,end=i-1;
            while(st<end){
                int sum=nums[st]+nums[end];
                if(sum>target) end--;
                else if(sum<target) st++;
                else{
                    set.add(Arrays.asList(nums[st], nums[end], nums[i]));
                    st++;
                    end--;
                    while (st < end && nums[st] == nums[st - 1]) {
                        st++;
                    }
                    while (st < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                }
            }
        }
         return new ArrayList<>(set);
    }
}