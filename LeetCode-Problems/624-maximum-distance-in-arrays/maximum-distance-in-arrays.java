class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // double diff=Integer.MIN_VALUE;
        // for(int i=0;i<arrays.size()-1;i++){
        //     List<Integer> a=arrays.get(i);
        //     int minA=a.get(0);
        //     int maxA=a.get(a.size()-1);
        //     for(int j=i+1;j<arrays.size();j++){
        //         List<Integer> b=arrays.get(j);
        //         int minB=b.get(0);
        //         int maxB=b.get(b.size()-1);
        //         diff=Math.max(diff,Math.abs(minA-maxB));
        //         diff=Math.max(diff,Math.abs(maxA-minB));
        //     }
        // }
        // return (int)diff;
        int min=arrays.get(0).get(0);
        int max=arrays.get(0).get(arrays.get(0).size()-1);
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