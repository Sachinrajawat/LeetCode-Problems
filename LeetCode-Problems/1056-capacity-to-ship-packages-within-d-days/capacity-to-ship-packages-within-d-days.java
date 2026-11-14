class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int st=weights[0], end=0;
        for(int weight:weights){
            st=Math.max(weight, st);
            end+=weight;
        }
        int ans=end;
        while(st<=end){
            int mid=st+(end-st)/2;
            int count=0, sum=0;
            for(int i=0;i<n;i++){
                sum+=weights[i];
                if(sum>mid){
                    count++;
                    sum=weights[i];
                }
            }
            if(sum<=mid) count++;
            if(count<=days){
                ans=Math.min(ans,mid);
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return ans;
    }
}