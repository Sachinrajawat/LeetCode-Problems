class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> array=new ArrayList<>();
        ArrayList<Integer> arr1=new ArrayList<>();
        arr1.add(1);
        array.add(arr1);

        for(int i=1;i<numRows;i++){
            int size=array.get(i-1).size();
            ArrayList<Integer> arr=new ArrayList<>();
            arr.add(1);
            for(int j=0;j<size-1;j++){
                arr.add(array.get(i-1).get(j)+array.get(i-1).get(j+1));
            }
            arr.add(1);
            array.add(arr);
        }
        return array;
    }
}