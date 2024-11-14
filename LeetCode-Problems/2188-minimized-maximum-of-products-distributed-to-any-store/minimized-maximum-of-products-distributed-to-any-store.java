class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int start=1,end=(int)10e5;
        int ans=Integer.MAX_VALUE;
        while(start<=end){
            int mid=start+(end-start)/2, count=0;
            for(int i=0;i<quantities.length;i++){
                count+=quantities[i]/mid;
                if(quantities[i]%mid!=0) count++;
                if(count>n) break;
            }
            if(count<=n){
                ans=mid;
                end=mid-1;
            }
            else start=mid+1;
        }
        return ans;
    }
}