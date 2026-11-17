class Solution {
    public void solve(int[] nums, int idx, Set<List<Integer>> set, List<Integer> arr){
        if(idx>=nums.length){
            set.add(arr);
            return;
        }
        solve(nums,idx+1, set, arr);
        ArrayList<Integer> temp=new ArrayList<>(arr);
        temp.add(nums[idx]);
        solve(nums, idx+1, set, temp);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set=new HashSet<>();
        List<Integer> arr=new ArrayList<>();
        solve(nums, 0, set, arr);
        // System.out.println(set);
        List<List<Integer>> list=new ArrayList<>();
        for(var s:set){
            list.add(s);
        }
        
        return list;
    }
}