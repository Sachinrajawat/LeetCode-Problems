class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int count1=0, count2=0, maj1=Integer.MIN_VALUE, maj2=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(maj1==nums[i]){
                count1++;
            }
            else if(maj2==nums[i]){
                count2++;
            }
            else if(count1==0){
                count1=1;
                maj1=nums[i];
            }
            else if(count2==0){
                count2=1;
                maj2=nums[i];
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==maj1) count1++;
            else if(nums[i]==maj2) count2++;
        }
        if(count1>nums.length/3)
        list.add(maj1);
        if(count2>nums.length/3)
        list.add(maj2);

        return list;
    }
}