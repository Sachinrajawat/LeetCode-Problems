class Solution {
    public List<String> buildArray(int[] target, int n) {
        int num=1;
        List<String> list=new ArrayList<>();
        
        int i=0;
        while(i<target.length){
            if(num==target[i]){
                list.add("Push");
                num++;
                i++;
            }
            else{
                list.add("Push");
                list.add("Pop");
                num++;
            }

        }
        return list;
    }
}