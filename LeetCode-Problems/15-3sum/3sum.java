class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set=new HashSet<>();
        for(int i=2;i<nums.length;i++){
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int j=0;j<i;j++){
                if(i!=j){
                    int comp=-1*nums[i]-nums[j];
                    if(map.containsKey(comp)){
                        ArrayList<Integer> arr=new ArrayList<>();
                        arr.add(nums[i]);
                        arr.add(nums[j]);
                        arr.add(nums[map.get(comp)]);
                        set.add(arr);
                    }
                    map.put(nums[j],j);
                }
            }
        }
        List<List<Integer>> list=new ArrayList<>(set);
        return list;
    }
}