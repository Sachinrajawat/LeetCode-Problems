class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> list=new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            List<Integer> row = new ArrayList<>();
            
                row.add(intervals[i][0]);
                row.add(intervals[i][1]);
            list.add(row);
        }
        System.out.println(list);
        List<List<Integer>> ans=new ArrayList<>();
        while(list.size()>0){
            int x=list.get(0).get(0);
            int y=list.get(0).get(1);
            int i=1;
            while(i<list.size()){
                if(list.get(i).get(0)>=x &&list.get(i).get(0)<=y || list.get(i).get(0)<=x &&list.get(i).get(1)>=x){
                    x=Math.min(x,list.get(i).get(0));
                    y=Math.max(y,list.get(i).get(1));
                    list.remove(i);
                }
                else i++;
            }
            ans.add(new ArrayList<>(List.of(x,y)));
            list.remove(0);
        }
        int[][] ans1=new int[ans.size()][2];
        for(int j=0;j<ans.size();j++){
            ans1[j][0]=ans.get(j).get(0);
            ans1[j][1]=ans.get(j).get(1);
        }
        return ans1;
    }
}