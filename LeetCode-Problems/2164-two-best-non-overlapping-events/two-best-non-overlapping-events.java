class Solution {
    public int binarySearch(int[][] events,int endTime,int n){
        int l=0,r=n-1,result=n;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(events[mid][0]>endTime){
                result=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return result;
    }
    public int solve(int[][] events,int idx,int count,int n,int[][] dp){
        if(count==2 || idx>=n) return 0;
        if(dp[idx][count]!=-1) return dp[idx][count];
        int nextValidIndex =binarySearch(events,events[idx][1],n);
        int take=events[idx][2]+solve(events,nextValidIndex,count+1,n,dp);
        int not_take=solve(events,idx+1,count,n,dp);
        return dp[idx][count]=Math.max(take,not_take);
    }
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        int n=events.length;
        int[][] dp=new int[n+1][3];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(events,0,0,n,dp);
    }
}