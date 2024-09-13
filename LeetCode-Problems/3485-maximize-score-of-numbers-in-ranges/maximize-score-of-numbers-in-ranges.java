class Solution {
    public boolean canSolve(int[] start,int mid,int d){
            int prev=start[0];
            for(int i=1;i<start.length;i++){
                if(prev+mid>start[i]+d) return false;
                prev=Math.max(start[i],prev+mid);
            }
            return true;
    }
    public int maxPossibleScore(int[] start, int d) {
        int ans=-1;
        int st=0,end=(int)10e10;
        Arrays.sort(start);
        while(st<=end){
            int mid=st+(end-st)/2;
            if(canSolve(start,mid,d)){
                ans=mid;
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
}