class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer,String> tr=new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<heights.length;i++) tr.put(heights[i],names[i]);
        int j=0;
        for(var key:tr.keySet()) names[j++]=tr.get(key);
        return names;
    }
}