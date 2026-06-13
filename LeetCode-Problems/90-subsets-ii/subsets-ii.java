class Solution {
    public void solve(int[] nums,int idx, Set<List<Integer>> ans){
        if(idx==nums.length) return;
        int size=ans.size();
        List<List<Integer>> list=new ArrayList<>(ans);
        for(int i=0;i<size;i++){
            List<Integer> l=new ArrayList<>(list.get(i));
            l.add(nums[idx]);
            ans.add(l);
        }
        solve(nums, idx+1, ans);
        return;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans=new HashSet<>();
        List<Integer> arr=new ArrayList<>();
        ans.add(arr);
        solve(nums, 0, ans);
        return new ArrayList(ans);
    }
}