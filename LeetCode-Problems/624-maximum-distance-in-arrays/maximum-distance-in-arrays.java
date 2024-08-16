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
        System.out.println(min+" "+max);
        double ans=0;
        for(int i=1;i<arrays.size();i++){
            ans=Math.max(ans,Math.abs(arrays.get(i).get(arrays.get(i).size()-1)-min));
            ans=Math.max(ans,Math.abs(max-arrays.get(i).get(0)));
            min=Math.min(min,arrays.get(i).get(0));
            max=Math.max(arrays.get(i).get(arrays.get(i).size()-1),max);
        }
        return (int)ans;
    }
}