class Solution {
    public int findMinDifference(List<String> timePoints) {
        int ans=Integer.MAX_VALUE;
        // ArrayList<Integer> arr=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<timePoints.size();i++){
            int min=Integer.parseInt(timePoints.get(i).substring(0,2))*60;
            min+=Integer.parseInt(timePoints.get(i).substring(3,5));
            // arr.add(min);
            pq.add(min);
        }
        // Collections.sort(arr);
        // for(int i=0;i<arr.size()-1;i++){
        //     int x=arr.get(i+1)-arr.get(i);
        //     ans=Math.min(ans,x);
        // }
        int first=pq.peek(),last=0;
        int prev=pq.remove();
        while(pq.size()>0){
            if(pq.size()==1) last=pq.peek();
            int x=Math.abs(prev-pq.peek());
            prev=pq.remove();
            ans=Math.min(ans,x);
        }
        // int circularDiff=1440+arr.get(0)-arr.get(arr.size()-1);
        int circularDiff=1440+first-last;
        ans = Math.min(ans, circularDiff);
        return ans;
    }
}