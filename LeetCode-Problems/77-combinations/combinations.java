class Solution {
    public void combinations(List<List<Integer>> ans,int n,int k,List<Integer> arr,int idx){
        if(arr.size()==k){
            List<Integer> list=new ArrayList<>(arr);
            ans.add(list);
            return;
        }
        for(int i=idx;i<=n;i++){
            arr.add(i);
            combinations(ans,n,k,arr,i+1);
            arr.remove(arr.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        combinations(ans,n,k,arr,1);
        return ans;
    }
}