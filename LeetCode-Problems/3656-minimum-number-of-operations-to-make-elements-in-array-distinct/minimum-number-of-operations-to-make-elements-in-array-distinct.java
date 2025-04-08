class Solution {
    public int minimumOperations(int[] nums) {
        int c=0;
        int n=nums.length;
        for(int i=0;i<n;i+=3){
            
                Set<Integer> set=new HashSet<>();
            for(int j=i;j<n;j++){
                if(set.contains(nums[j])){
                    
                    c++;
                    break;
                }
                else{
                    set.add(nums[j]);
                }
            }
        }
        return c;
    }
}