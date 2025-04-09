class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list=new ArrayList<>();
        int i=0, num=1;
        while(i<target.length){
            list.add("Push");
            if(num==target[i]) i++;
            else list.add("Pop");
            num++;

        }
        return list;
    }
}