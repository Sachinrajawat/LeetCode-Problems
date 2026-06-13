class Solution {
    public void solve(int[] nums,int idx, List<List<Integer>> ans){
        if(idx==nums.length) return;
        int size=ans.size();
        for(int i=0;i<size;i++){
            List<Integer> l=new ArrayList<>(ans.get(i));
            l.add(nums[idx]);
            ans.add(l);
        }
        solve(nums, idx+1, ans);
        return;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        ans.add(arr);
        solve(nums, 0, ans);
        return ans;
    }
}