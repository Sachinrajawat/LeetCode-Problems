class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set=new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int j=0;
        for(var num:set){
            nums[j++]=num;
        }
        return set.size();
    }
}