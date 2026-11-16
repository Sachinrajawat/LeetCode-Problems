class Solution {
    public void solve(List<List<Integer>> list,List<Integer> arr, int[] candidates, int idx,int target){  
        if(idx>=candidates.length) return;
        if(target==0){
            list.add(arr);
            return;
        }
        solve(list,arr, candidates, idx+1, target);
        if(candidates[idx]<=target){
            List<Integer> temp=new ArrayList<>(arr);
            temp.add(candidates[idx]);
            solve(list,temp, candidates, idx, target-candidates[idx]);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        solve(list, new ArrayList<>(), candidates,0, target);
        return list;
    }
}