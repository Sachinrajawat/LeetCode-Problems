class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        
        int min=arrays.get(0).get(0); //min of 1st index list
        int max=arrays.get(0).get(arrays.get(0).size()-1); //max of 1st index list
        double ans=0;
        for(int i=1;i<arrays.size();i++){
            int n=arrays.get(i).size();
            List<Integer> l=arrays.get(i);
            ans=Math.max(ans,Math.abs(l.get(n-1)-min));
            ans=Math.max(ans,Math.abs(max-l.get(0)));
            min=Math.min(min,l.get(0));
            max=Math.max(l.get(n-1),max);
        }
        return (int)ans;
    }
}