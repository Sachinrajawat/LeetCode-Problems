class Solution {
    public void permutation(List<List<Integer>> ans,int[] nums,List<Integer> arr,boolean[] isVisited){
        
        if(arr.size()==nums.length){
            List<Integer> list=new ArrayList<>(arr);
            ans.add(list);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(isVisited[i]==false){
                arr.add(nums[i]);
                isVisited[i]=true;
                permutation(ans,nums,arr,isVisited);
                isVisited[i]=false;
                arr.remove(arr.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        boolean[] isVisited=new boolean[nums.length];
        permutation(ans,nums,arr,isVisited);
        return ans;
    }
}