class Solution {
    public int findMinDifference(List<String> timePoints) {
        int ans=Integer.MAX_VALUE;
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<timePoints.size();i++){
            int min=Integer.parseInt(timePoints.get(i).substring(0,2))*60;
            min+=Integer.parseInt(timePoints.get(i).substring(3,5));
            arr.add(min);
        }
        Collections.sort(arr);
        System.out.println(arr);
        for(int i=0;i<arr.size()-1;i++){
            int x=arr.get(i+1)-arr.get(i);
            ans=Math.min(ans,x);
        }
        int circularDiff = 1440 + arr.get(0) - arr.get(arr.size() - 1);
        ans = Math.min(ans, circularDiff);
        return ans;
    }
}