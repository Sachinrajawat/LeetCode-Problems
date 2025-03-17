class Solution {
    public boolean divideArray(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        int c=0;
        for(int num:nums){
            if(set.contains(num)){
                set.remove(num);
                c++;
            }
            else{
                set.add(num);
            }
        }
        return c==(nums.length/2);
    }
}