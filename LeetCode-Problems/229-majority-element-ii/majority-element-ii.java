class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length/3;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> list=new ArrayList<>();
        for(var key:map.keySet()){
            if(map.get(key)>n) list.add(key);
        }
        return list;
    }
}