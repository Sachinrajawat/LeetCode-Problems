class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> subList=new ArrayList<>();
        subList.add(1);
        list.add(subList);
        
        for(int i=1;i<numRows;i++){
            List<Integer> arr=new ArrayList<>();
            arr.add(1);
            List<Integer> l=list.get(list.size()-1);
            for(int j=0;j<l.size()-1;j++){
                arr.add(l.get(j)+l.get(j+1));
            }
            arr.add(1);
            list.add(arr);
        }
        return list;
    }
}