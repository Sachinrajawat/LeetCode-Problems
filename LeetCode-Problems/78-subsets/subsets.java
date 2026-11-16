class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        list.add(arr);
        for(int i=0;i<nums.length;i++){
            int end=list.size();
            // System.out.println(end);
            for(int j=0;j<end;j++){
                List<Integer> l=new ArrayList<>(list.get(j));
                l.add(nums[i]);
                list.add(l);
            }
            // System.out.println(list);
        }
        return list;
    }
}