class Solution {
    public void solve(List<List<Integer>> list,List<Integer> arr,int[] candidates,int target,int sum,int idx){
        if(sum>target) return;
        if(sum==target){
            List<Integer> a=new ArrayList<>(arr);
            list.add(a);
        }
        
        for(int i=idx;i<candidates.length;i++){
            arr.add(candidates[i]);
            sum+=candidates[i];
            solve(list,arr,candidates,target,sum,i);
            arr.remove(arr.size()-1);
            sum-=candidates[i];

        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        solve(list,arr,candidates,target,0,0);
        return list;
    }
}