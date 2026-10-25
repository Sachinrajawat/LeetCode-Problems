class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        if(nums.length<3) return list;
        Arrays.sort(nums);
        for(int k=0;k<nums.length-2;k++){
            if(k>0 && nums[k]==nums[k-1]){
                continue;
            }
            int target=-nums[k];
            int i=k+1, j=nums.length-1;
            while(i<j){
                if(nums[i]+nums[j]>target) j--;
                else if(nums[i]+nums[j]<target) i++;
                else{
                    while(i<j &&nums[i]==nums[i+1]){
                        i++;
                    }
                    while(j>i && nums[j]==nums[j-1]){
                        j--;
                    }
                    List<Integer> l=new ArrayList<>();
                    l.add(-target);
                    l.add(nums[i]);
                    l.add(nums[j]);
                    list.add(l);
                    i++;
                    j--;
                }
            }
        }
        return list;
    }
}