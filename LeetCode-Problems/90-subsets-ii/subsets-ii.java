class Solution {
    public void subset(List<List<Integer>> list,List<Integer> arr,int[] nums,int idx){
        
        List<Integer> l=new ArrayList<>(arr);
        if(!list.contains(l)) list.add(l);
        if(idx==nums.length) return;
        for(int i=idx;i<nums.length;i++){
            arr.add(nums[i]);
            subset(list,arr,nums,i+1);
            arr.remove(arr.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        Arrays.sort(nums);
        subset(list,arr,nums,0);
        return list;
    }
}