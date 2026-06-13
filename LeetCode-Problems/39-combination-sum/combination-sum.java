class Solution {
    public void solve(List<List<Integer>> list, List<Integer> current, int[] candidates, int target, int idx){
        if(target==0){
            list.add(new ArrayList<>(current));
            return;
        }
        if(idx==candidates.length) return;
        solve(list, current, candidates, target, idx+1);
        if(candidates[idx]<=target){
            current.add(candidates[idx]);
            solve(list, current, candidates, target-candidates[idx], idx);
            current.remove(current.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        solve(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
}