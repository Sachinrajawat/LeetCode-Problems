class Solution {
    public void solve(List<List<Integer>> list,List<Integer> arr, int[] candidates, int idx,int target){  
        if(target==0){
            list.add(arr);
            return;
        }
        if(idx>=candidates.length ||candidates[idx]>target) return;
        
        
        // if(candidates[idx]<=target){
            List<Integer> temp=new ArrayList<>(arr);
            temp.add(candidates[idx]);
           
            solve(list,temp, candidates, idx+1, target-candidates[idx]);
             while(idx+1<candidates.length && candidates[idx+1]==candidates[idx]) idx++;
             solve(list,arr, candidates, idx+1, target);
        // }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list=new ArrayList<>();
        solve(list, new ArrayList<>(), candidates,0, target);
        return list;
    }
}