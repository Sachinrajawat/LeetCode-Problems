class Solution {
    public void solve(List<List<Integer>> ans, int[] candidates, int target, int idx, List<Integer> current){
        if(target==0){
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(candidates[idx]>target) break;
            if(i>idx && candidates[i-1]==candidates[i]) continue;
            current.add(candidates[i]);
            solve(ans, candidates, target-candidates[i], i+1, current);
            current.remove(current.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        solve(ans, candidates, target, 0, new ArrayList<>());
        return ans;
    }
}