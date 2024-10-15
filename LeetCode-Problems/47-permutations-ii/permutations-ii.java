class Solution {
    public void permutation(List<List<Integer>> ans,int[] nums,int idx){
        int n=nums.length;
        if(idx==n-1){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(nums[i]);
            }
            if(!ans.contains(list)) ans.add(list);
            return;
        }
        for(int i=idx;i<n;i++){
            swap(i,idx,nums);
            permutation(ans,nums,idx+1);
            swap(i,idx,nums);
        }
    }
    public void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        permutation(ans,nums,0);
        return ans;
    }
}