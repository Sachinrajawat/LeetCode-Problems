class Solution {
    public int next(int[] startTime,int idx,int target){
        int start=idx,end=startTime.length-1;
        int ans=startTime.length;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(startTime[mid]>=target){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            } 
        }
        return ans;
    }
    public int solve(int[] startTime, int[] endTime, int[] profit,int idx,int[] dp){
        if(idx>=startTime.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
            int nextIdx=next(startTime,idx+1,endTime[idx]);
            int a=profit[idx]+solve(startTime, endTime, profit,nextIdx,dp);
            int b=solve(startTime, endTime, profit, idx+1,dp);
            return dp[idx]=Math.max(a,b);

    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        for(int i=0;i<n;i++){
            pq.add(new int[]{startTime[i],endTime[i],profit[i]});
        }
        int idx=0;
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            startTime[idx]=a[0];
            endTime[idx]=a[1];
            profit[idx]=a[2];
            idx++;
        }
        int[] dp=new int[startTime.length+1]; 
        Arrays.fill(dp,-1);
        return solve(startTime, endTime, profit,0,dp);
    }
}