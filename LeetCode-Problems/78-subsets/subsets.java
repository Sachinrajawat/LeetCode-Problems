class Solution {
    public void solve(int[] nums, int idx, List<List<Integer>> list, List<Integer> arr){
        if(idx>=nums.length){
            list.add(arr);
            return;
        }

        solve(nums,idx+1, list, arr);
        ArrayList<Integer> temp=new ArrayList<>(arr);
        temp.add(nums[idx]);
        solve(nums, idx+1, list, temp);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        solve(nums,0, list, arr);
        return list;
    }
}