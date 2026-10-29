class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        int count=1, max=1, last=Integer.MIN_VALUE;
        Set<Integer> set=new TreeSet<>(); 
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        System.out.println(set);
        for(int val:set){
            if(last==val-1) count++;
            else{
                max=Math.max(count, max);
                count=1;
            }
            last=val;
            // System.out.println(last);
        }
        return Math.max(max, count);
    }
}