class Solution {
    public void subsets(List<List<Integer>> ans,int[] nums,List<Integer> arr,int idx){
        
        List<Integer> a=new ArrayList<>(arr);
        ans.add(a);
        if(idx==nums.length) return;
        for(int i=idx;i<nums.length;i++){
            arr.add(nums[i]);
            subsets(ans,nums,arr,i+1);
            arr.remove(arr.size()-1);
        }
        return;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        subsets(ans,nums,arr,0);
        return ans;
    }
}