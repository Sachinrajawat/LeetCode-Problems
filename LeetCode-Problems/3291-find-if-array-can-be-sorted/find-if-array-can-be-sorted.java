class Solution {
    public boolean canSortArray(int[] nums) {
        if(nums.length==1) return true;
        Map<Integer,Integer> map=new LinkedHashMap<>();
        for(int i=0;i<nums.length;i++){
            String s=Integer.toBinaryString(nums[i]);
            int countOnes = s.length()-s.replace("1","").length();
            map.put(nums[i],countOnes);
        }
        for(int i=nums.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(nums[j]>nums[j+1]){
                    if(map.get(nums[j])!=map.get(nums[j+1])) return false;
                    else{
                        int temp=nums[j];
                        nums[j]=nums[j+1];
                        nums[j+1]=temp;
                    }
                }
            }
        }
        return true;
    }
}