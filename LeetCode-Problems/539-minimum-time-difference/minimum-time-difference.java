class Solution {
    public int findMinDifference(List<String> timePoints) {
        int ans=Integer.MAX_VALUE;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<timePoints.size();i++){
            int min=Integer.parseInt(timePoints.get(i).substring(0,2))*60;
            min+=Integer.parseInt(timePoints.get(i).substring(3,5));
            pq.add(min);
        }
        int first=pq.peek(),last=0;
        int prev=pq.remove();
        while(pq.size()>0){
            if(pq.size()==1) last=pq.peek();
            int x=Math.abs(prev-pq.peek());
            prev=pq.remove();
            ans=Math.min(ans,x);
        }
        int circularDiff=1440+first-last;
        ans=Math.min(ans,circularDiff);
        return ans;
    }
}